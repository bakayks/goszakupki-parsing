package com.example.zakupki.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "organisation")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Organisation {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    UUID id;

    @Column(name = "name_of_org", columnDefinition = "TEXT")
    String nameOfOrg;

    @Column(name = "type_of_ownership", columnDefinition = "TEXT")
    String typeOfOwnership;

    @Column(name = "inn_of_ownership")
    String innOfOwnership;

    @Column(name = "fio")
    String fio;

    @Column(name = "position")
    String position;

    @Column(name = "locality")
    String locality;

    @Column(name = "address")
    String address;

    @Column(name = "type")
    String type;
}
