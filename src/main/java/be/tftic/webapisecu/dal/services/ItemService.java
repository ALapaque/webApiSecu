package be.tftic.webapisecu.dal.services;

import be.tftic.webapisecu.dal.entities.Items;
import be.tftic.webapisecu.dal.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ItemService {

    @Autowired
    private ItemRepository repo;

    public List<Items> getAll(){

        return repo.findAll();
    }

    public Items create(Items i){

        Objects.requireNonNull(i);
        return repo.save(i);
    }


}
