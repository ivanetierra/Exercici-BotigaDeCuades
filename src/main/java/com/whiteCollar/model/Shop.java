package com.whiteCollar.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idShop")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="maxCapacity")
    private int maxCapacity;

    @OneToMany(mappedBy="shop")
    private List<Collar> collars ;

    public Shop(Long id, String name, int maxCapacity) {
        this.id = id;
        this.name = name;
        this.maxCapacity = maxCapacity;
    }

    //CONFLICTO CON LA LISTA COLLARS!!!!!! ?!?!?!?!?

    /*public Shop(Long id, String name, int maxCapacity, List<Collar> collars) {
        this.id = id;
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.collars = collars;
    }*/

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

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public List<Collar> getCollars() {
        return collars;
    }

    public void setCollars(Collar collar) {

        this.collars.add(collar);
    }
}
