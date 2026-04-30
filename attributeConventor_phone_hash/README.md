# Phone Hash Methodology

This set shows the full pattern for hiding a phone number while keeping lookup and login workable.

Files:
- `AttributeHashingService.java` - stable SHA-256 hash builder
- `PersonEntity.java` - encrypted `phone` plus derived `phoneHash`
- `AuthFlow.java` - login flow that authenticates by hash with fallback for legacy plain usernames
- `v1.0.003__backfill-person-phone-hash.sql` - migration for existing rows

Core idea:
1. Store the original phone in encrypted form.
2. Store a stable hash in a separate column for search and uniqueness.
3. Use the hash in auth and lookup flows.
4. Keep a temporary fallback for legacy data during migration.
