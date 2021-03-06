package br.dev.wesraiuga.bds_task01_clientscrud.services;

import br.dev.wesraiuga.bds_task01_clientscrud.dto.ClientDTO;
import br.dev.wesraiuga.bds_task01_clientscrud.entities.Client;
import br.dev.wesraiuga.bds_task01_clientscrud.exceptions.ResourceNotFoundException;
import br.dev.wesraiuga.bds_task01_clientscrud.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
        Page<Client> list = repository.findAll(pageRequest);

        return list.map(ClientDTO::new);
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Optional<Client> obj = repository.findById(id);

        Client entity = obj.orElseThrow(() -> new ResourceNotFoundException("Client not found (id: " + id + ")"));

        return new ClientDTO(entity);
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto) {
        Client entity = new Client(
                dto.getId(),
                dto.getName(),
                dto.getCpf(),
                dto.getIncome(),
                dto.getBirthDate(),
                dto.getChildren()
        );

        entity = repository.save(entity);

        return new ClientDTO(entity);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto) {
        try {
            Client entity = repository.getOne(id);
            entity.setName(dto.getName() != null ? dto.getName() : entity.getName());
            entity.setCpf(dto.getCpf() != null ? dto.getCpf() : entity.getCpf());
            entity.setIncome(dto.getIncome() != null ? dto.getIncome() : entity.getIncome());
            entity.setBirthDate(dto.getBirthDate() != null ? dto.getBirthDate() : entity.getBirthDate());
            entity.setChildren(dto.getChildren() != null ? dto.getChildren() : entity.getChildren());

            entity = repository.save(entity);

            return new ClientDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Client not found (id: " + id + ")");
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }
        catch (Exception e ) {
            throw new ResourceNotFoundException("Client not found (id: " + id + ")");
        }
    }

}
