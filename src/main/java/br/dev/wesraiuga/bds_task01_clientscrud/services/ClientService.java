package br.dev.wesraiuga.bds_task01_clientscrud.services;

import br.dev.wesraiuga.bds_task01_clientscrud.dto.ClientDTO;
import br.dev.wesraiuga.bds_task01_clientscrud.entities.Client;
import br.dev.wesraiuga.bds_task01_clientscrud.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
        Page<Client> list = repository.findAll(pageRequest);

        return list.map(ClientDTO::new);
    }

}
