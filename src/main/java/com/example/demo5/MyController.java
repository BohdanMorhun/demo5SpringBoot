package com.example.demo5;

import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {

    private final ClientRepository clientRepository;

    MyController(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @GetMapping("get")
    public List<Client> doGet(@RequestParam(required = false,defaultValue = "0") Integer page){
        return clientRepository.findAll(PageRequest.of(page,5)).getContent();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String OnExeption(){
    return "Wrong page number";
    }
}
