package br.com.oficina.dao;

import br.com.oficina.model.Maquina;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class MaquinaDAO {

    EntityManager entityManager;

    public void salvar(Maquina m) throws Exception {
        try {
            entityManager = PersistenceUtil.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(m);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            throw new Exception("Erro ao inserir registro!");
        } finally {
            entityManager.close();
        }
    }

    public void editar(Maquina m) {
        try {
            entityManager = PersistenceUtil.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(m);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

    }

    public boolean excluir(Maquina m) {
        try {
            entityManager = PersistenceUtil.createEntityManager();
            entityManager.getTransaction().begin();
            m = entityManager.find(Maquina.class, m.getId());
            entityManager.remove(m);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return false;
    }

    public List<Maquina> listar() {
        try {
            entityManager = PersistenceUtil.createEntityManager();
            Query query = entityManager.createQuery("SELECT m FROM Maquina m");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }
}
