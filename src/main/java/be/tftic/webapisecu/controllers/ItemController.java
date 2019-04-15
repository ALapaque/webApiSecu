package be.tftic.webapisecu.controllers;

import be.tftic.webapisecu.dal.entities.Items;
import be.tftic.webapisecu.dal.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/item")
public class ItemController {

    @Autowired
    private ItemService service;

    @GetMapping
    public ResponseEntity<List<Items>> getAll(){

        return new ResponseEntity<List<Items>>(service.getAll(), HttpStatus.FOUND);

    }

    @PostMapping
    public ResponseEntity<Items> create(@RequestBody Items i){
        return new ResponseEntity<Items>(service.create(i), HttpStatus.CREATED);
    }
}
