package br.com.oficina.controller;

import br.com.oficina.dao.AtendenteDAO;
import br.com.oficina.model.Atendente;
import java.util.List;
import javax.faces.bean.ManagedBean;
import br.com.oficina.util.MesagensUtil;


@ManagedBean
public class AtendenteBean {

    private Atendente atendente = new Atendente();
    private AtendenteDAO dao = new AtendenteDAO();

    public void salvar() {
        if (atendente.getId() == 0) {
            try {
                dao.salvar(atendente);
            } catch (Exception ex) {
                MesagensUtil.MessagemInfo(ex.getMessage());
            }
        } else {
            dao.editar(atendente);
        }
        atendente = new Atendente();
        MesagensUtil.MessagemInfo("Registro salvo com sucesso!");
    }

    public void excluir(Atendente atendente) {
        if (dao.excluir(atendente)) {
            MesagensUtil.MessagemInfo("Atendente excluido!");
        } else {
            MesagensUtil.MessagemErro("Atendente nÃ£o excluido!");
        }

    }

    public void carregar(Atendente atendente) {
        this.atendente = atendente;
    }

    /**
     * @return the lista
     */
    public List<Atendente> getLista() {
        return dao.listar();
    }

    /**
     * @return the atendente
     */
    public Atendente getAtendente() {
        return atendente;
    }

    /**
     * @param atendente the atendente to set
     */
    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }

}
