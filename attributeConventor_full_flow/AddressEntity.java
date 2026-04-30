package com.nexus.infrastructure.persistence.event;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nexus.infrastructure.security.crypto.EncryptedStringAttributeConverter;
import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.locationtech.jts.geom.Geometry;

@Getter
@Setter
@Entity
@Builder
@ToString(exclude = "geom")
@NoArgsConstructor
@AllArgsConstructor
@Table(
    name = "address",
    indexes = {@Index(name = "idx_address_city", columnList = "city")})
public class AddressEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "street")
  @Convert(converter = EncryptedStringAttributeConverter.class)
  private String street;

  @Column(name = "apartment_number", length = 50)
  @Convert(converter = EncryptedStringAttributeConverter.class)
  private String apartmentNumber;

  @Column(name = "building_number", length = 50)
  @Convert(converter = EncryptedStringAttributeConverter.class)
  private String buildingNumber;

  @Column(name = "city")
  private String city;

  @Column(name = "state")
  private String state;

  @Column(name = "latitude")
  private Double latitude;

  @Column(name = "longitude")
  private Double longitude;

  @JsonIgnore
  @ToStringExclude
  @Column(name = "geom", columnDefinition = "geometry(Point, 4326)")
  private Geometry geom;
}
