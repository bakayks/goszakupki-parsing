package com.example.zakupki.repositories;

import com.example.zakupki.entities.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrganisationRepo extends JpaRepository<Organisation, UUID> {
}
