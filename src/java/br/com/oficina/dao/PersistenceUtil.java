package br.com.oficina.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class PersistenceUtil {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("Crud-JSF-WEB2PU");

    public static EntityManager createEntityManager() {
        try {
            return factory.createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
