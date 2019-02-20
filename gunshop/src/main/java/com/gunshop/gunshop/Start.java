package com.gunshop.gunshop;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class Start {
    private ShopRepo shopRepo;
    private GunRepo gunRepo;
    private SellerRepo sellerRepo;
    private CashRegisterRepo cashRegisterRepo;
    private ClientRepo clientRepo;

    public Start(ShopRepo shopRepo, GunRepo gunRepo, SellerRepo sellerRepo, CashRegisterRepo cashRegisterRepo, ClientRepo clientRepo) {
        this.shopRepo = shopRepo;
        this.gunRepo = gunRepo;
        this.sellerRepo = sellerRepo;
        this.cashRegisterRepo = cashRegisterRepo;
        this.clientRepo = clientRepo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void Start() {
        Shop shop1 = new Shop();
        shop1.setName("AmmuNation");
        shop1.setAdress("SanAnderas, GreanPark7");

        Shop shop2 = new Shop();
        shop2.setName("Pukawka");
        shop2.setAdress("Gdynia, Morska15");

        Gun gun1 = new Gun();
        gun1.setName("M4A1");
        gun1.setType("Carabine");
        gun1.setCaliber("5.56mm");
        gun1.setPrice(5200);
        gun1.setShop(shop1);

        Gun gun2 = new Gun();
        gun2.setName("M4A5");
        gun2.setType("Carabine");
        gun2.setCaliber("5.59mm");
        gun2.setPrice(5700);
        gun2.setShop(shop1);

        Gun gun3 = new Gun();
        gun3.setName("Glock19");
        gun3.setType("Pistol");
        gun3.setCaliber("9x19 Para");
        gun3.setPrice(2200);
        gun3.setShop(shop2);

        CashRegister cashRegister1 = new CashRegister();
        cashRegister1.setSerialnumber(9083190);

        CashRegister cashRegister2 = new CashRegister();
        cashRegister2.setSerialnumber(8083110);

        Client client1 = new Client();
        client1.setName("Jan");
        client1.setSurname("Kowalski");

        Client client2 = new Client();
        client2.setName("Przemysław");
        client2.setSurname("Bykowski");

        Set<CashRegister> cashRegisterSet = new HashSet<>();
        cashRegisterSet.add(cashRegister1);
        cashRegisterSet.add(cashRegister2);

        Set<Client> clientSet = new HashSet<>();
        clientSet.add(client1);
        clientSet.add(client2);

        client1.setCashRegisterSet(cashRegisterSet);
        client2.setCashRegisterSet(Collections.singleton(cashRegister1));
        cashRegister1.setClientSet(clientSet);
        cashRegister2.setClientSet(Collections.singleton(client2));

        Seller seller1 = new Seller();
        seller1.setName("John");
        seller1.setSurname("Cena");
        seller1.setCashRegister(cashRegister1);

        Seller seller2 = new Seller();
        seller2.setName("Ben");
        seller2.setSurname("Toneli");
        seller2.setCashRegister(cashRegister2);

        Seller seller3 = new Seller();
        seller3.setName("Johny");
        seller3.setSurname("Cash");
        seller3.setCashRegister(cashRegister2);

        Set<Seller> sellerSet1 = new HashSet<>();
        sellerSet1.add(seller1);
        sellerSet1.add(seller2);
        shop1.setSellerSet(sellerSet1);

        Set<Seller> sellerSet2 = new HashSet<>();
        sellerSet2.add(seller3);
        shop2.setSellerSet(sellerSet2);

        cashRegisterRepo.save(cashRegister1);
        cashRegisterRepo.save(cashRegister2);
        clientRepo.save(client1);
        clientRepo.save(client2);
        sellerRepo.save(seller1);
        sellerRepo.save(seller2);
        sellerRepo.save(seller3);
        shopRepo.save(shop1);
        shopRepo.save(shop2);
        gunRepo.save(gun1);
        gunRepo.save(gun2);
        gunRepo.save(gun3);


    }
}
