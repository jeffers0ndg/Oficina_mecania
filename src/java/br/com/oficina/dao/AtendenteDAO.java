package br.com.oficina.dao;

import br.com.oficina.model.Atendente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Renato Altino
 */
public class AtendenteDAO {

    EntityManager entityManager;

    public void salvar(Atendente a) throws Exception {
        try {
            entityManager = PersistenceUtil.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(a);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            throw new Exception("Erro ao inserir registro!");
        } finally {
            entityManager.close();
        }
    }

    public void editar(Atendente a) {
        try {
            entityManager = PersistenceUtil.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(a);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

    }

    public boolean excluir(Atendente a) {
        try {
            entityManager = PersistenceUtil.createEntityManager();
            entityManager.getTransaction().begin();
            a = entityManager.find(Atendente.class, a.getId());
            entityManager.remove(a);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return false;
    }

    public List<Atendente> listar() {
        try {
            entityManager = PersistenceUtil.createEntityManager();
            Query query = entityManager.createQuery("SELECT a FROM Atendente a");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }
}
