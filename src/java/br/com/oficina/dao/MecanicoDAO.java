package br.com.oficina.dao;

import br.com.oficina.model.Mecanico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class MecanicoDAO {

    EntityManager entityManager;

    public void salvar(Mecanico m) throws Exception {
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

    public void editar(Mecanico m) {
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

    public boolean excluir(Mecanico m) {
        try {
            entityManager = PersistenceUtil.createEntityManager();
            entityManager.getTransaction().begin();
            m = entityManager.find(Mecanico.class, m.getId());
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

    public List<Mecanico> listar() {
        try {
            entityManager = PersistenceUtil.createEntityManager();
            Query query = entityManager.createQuery("SELECT m FROM Mecanico m");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }
}
