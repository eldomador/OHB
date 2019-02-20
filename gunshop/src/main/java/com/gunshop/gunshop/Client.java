package com.gunshop.gunshop;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @ManyToMany
    @JoinTable(
            name = "CLIENT_CASHREGISTER",
            joinColumns = @JoinColumn(name = "CLIENT"),
            inverseJoinColumns = @JoinColumn(name = "CASHREGISTER")
    )
    private Set<CashRegister> cashRegisterSet;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<CashRegister> getCashRegisterSet() {
        return cashRegisterSet;
    }

    public void setCashRegisterSet(Set<CashRegister> cashRegisterSet) {
        this.cashRegisterSet = cashRegisterSet;
    }
}
