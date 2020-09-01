package com.whiteCollar.controller;

import com.whiteCollar.Exceptions.ShopNotFoundException;
import com.whiteCollar.model.Collar;
import com.whiteCollar.model.Shop;
import com.whiteCollar.repository.CollarRepository;
import com.whiteCollar.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;





//@Controller
//@RequestMapping

@RestController
public class ShopController {

    //el error dice que faltaba este bean aquí!!!!!!!!!

    @Bean(name="entityManagerFactory")
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        return sessionFactory;
    }



    @Autowired
    ShopRepository shopRepository;
    CollarRepository collarRepository;

    ShopController(ShopRepository shopRepository, CollarRepository paintRepository)
    {
        this.shopRepository = shopRepository;
        this.collarRepository = paintRepository;


    }



    @GetMapping("/shops")
    List<Shop> getAllShops()
    {
        return shopRepository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/shops") //
    Shop newShop(@RequestBody Shop newShop)
    {
        return shopRepository.save(newShop);
    }

    @GetMapping("/shops/{shopId}")
    Shop one(@PathVariable Long shopId) {
        return shopRepository.findById(shopId).orElseThrow(() -> new ShopNotFoundException(shopId));
    }

    @GetMapping("/shops/{id}/collars")
    List<Collar> getAllCollars()
    {
        return collarRepository.findAll();
    }

    @PostMapping("/shops/{id}/collars")
    Collar newCollar(@RequestBody Collar newCollar) {return collarRepository.save(newCollar);}

    @DeleteMapping("/shops/{id}/collars") //
    void deletePaints(@PathVariable Long id) {
        collarRepository.deleteById(id);
    }

}

