package br.com.oficina.dao;

import br.com.oficina.model.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class UsuarioDAO {

    EntityManager entityManager;

    public void salvar(Usuario u) throws Exception {
        try {
            entityManager = PersistenceUtil.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(u);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            throw new Exception("Erro ao inserir registro!");
        } finally {
            entityManager.close();
        }
    }

    public void editar(Usuario u) {
        try {
            entityManager = PersistenceUtil.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(u);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

    }

    public boolean excluir(Usuario u) {
        try {
            entityManager = PersistenceUtil.createEntityManager();
            entityManager.getTransaction().begin();
            u = entityManager.find(Usuario.class, u.getId());
            entityManager.remove(u);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return false;
    }

    public List<Usuario> listar() {
        try {
            entityManager = PersistenceUtil.createEntityManager();
            Query query = entityManager.createQuery("SELECT u FROM Usuario u");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }
}
