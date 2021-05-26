package br.dev.wesraiuga.bds_task01_clientscrud.controllers;

import br.dev.wesraiuga.bds_task01_clientscrud.dto.ClientDTO;
import br.dev.wesraiuga.bds_task01_clientscrud.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ClientController.URL_PATH)
public class ClientController {

    @Autowired
    private ClientService service;

    public static final String URL_PATH = "/clients";

    @GetMapping
    public ResponseEntity<Page<ClientDTO>> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "10") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy
    ) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

        Page<ClientDTO> list = service.findAllPaged(pageRequest);

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id) {
        ClientDTO dto = service.findById(id);

        return ResponseEntity.ok().body(dto);
    }

}