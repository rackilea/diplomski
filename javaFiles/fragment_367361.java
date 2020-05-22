package db;

import javax.ejb.Singleton;


import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

@Singleton
public class MySingletonQueue implements RemoteQueue {

    private int next = 3;
    private ClientsJpaController cjc;

    @PersistenceUnit
    private EntityManagerFactory emf;

    @Resource
    private UserTransaction utx; 

    @PostConstruct
    public void initBean() {
        // Instantiate your controller here
        cjc = new ClientsJpaController(utx, emf);
    }

    // rest of the class ...

}