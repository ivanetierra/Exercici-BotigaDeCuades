package com.whiteCollar.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "collar")
public class Collar {

    @Id
    @GeneratedValue
    @Column(name="idCollar", unique = true)
    private Long id;

    @Column(name="mame")
    private String name;

    @Column(name="price")
    private double price;

    @Column(name="author")
    private String author;

    @Column(name="entryDate")
    private Date date;


    @ManyToOne (cascade=CascadeType.REFRESH)
    @JoinColumn(name = "Shop_idShop", insertable = false, updatable = false)
    private Shop shop;

    @Column(name = "Shop_idShop")
    private int idStore;

    public Collar() {
        createCurrentDate();
    };

    public Collar(Long id, String name,String author, double price,  Shop shop) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.shop = shop;
        createCurrentDate();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public com.whiteCollar.model.Shop getShop() {
        return shop;
    }

    public void setShop(com.whiteCollar.model.Shop shop) {
        this.shop = shop;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public void createCurrentDate() {
        this.date = new Date();
    }


    @Override
    public String toString() {
        return "Collar [id=" + id + ", name=" + name + ", price=" + price + ", author=" + author + ", date=" + date
                + ", shop=" + shop + "]";
    }

}