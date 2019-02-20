package com.gunshop.gunshop;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String adress;
    @OneToMany(mappedBy = "shop")
    private Set<Gun> gunSet;
    @OneToMany
    @JoinColumn(name = "SHOP_ID")
    private Set<Seller> sellerSet;

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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Set<Gun> getGunSet() {
        return gunSet;
    }

    public void setGunSet(Set<Gun> gunSet) {
        this.gunSet = gunSet;
    }

    public Set<Seller> getSellerSet() {
        return sellerSet;
    }

    public void setSellerSet(Set<Seller> sellerSet) {
        this.sellerSet = sellerSet;
    }
}
