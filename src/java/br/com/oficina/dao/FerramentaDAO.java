package br.com.oficina.dao;

import br.com.oficina.model.Ferramenta;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class FerramentaDAO {

    EntityManager entityManager;

    public void salvar(Ferramenta f) throws Exception {
        try {
            entityManager = PersistenceUtil.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(f);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            throw new Exception("Erro ao inserir registro!");
        } finally {
            entityManager.close();
        }
    }

    public void editar(Ferramenta f) {
        try {
            entityManager = PersistenceUtil.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(f);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

    }

    public boolean excluir(Ferramenta f) {
        try {
            entityManager = PersistenceUtil.createEntityManager();
            entityManager.getTransaction().begin();
            f = entityManager.find(Ferramenta.class, f.getId());
            entityManager.remove(f);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return false;
    }

    public List<Ferramenta> listar() {
        try {
            entityManager = PersistenceUtil.createEntityManager();
            Query query = entityManager.createQuery("SELECT f FROM Ferramenta f");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }
}
