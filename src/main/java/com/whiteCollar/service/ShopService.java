package com.whiteCollar.service;


import com.whiteCollar.model.Shop;
import com.whiteCollar.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ShopService{

    @Autowired
    private ShopRepository repo;

    public void save(Shop t) {
        repo.save(t);
    }
}
