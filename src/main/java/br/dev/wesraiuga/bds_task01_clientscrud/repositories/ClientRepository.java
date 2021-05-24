package br.dev.wesraiuga.bds_task01_clientscrud.repositories;

import br.dev.wesraiuga.bds_task01_clientscrud.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
