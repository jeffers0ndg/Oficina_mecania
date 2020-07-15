package br.com.oficina.controller;

import br.com.oficina.dao.FerramentaDAO;
import br.com.oficina.model.Ferramenta;
import java.util.List;
import javax.faces.bean.ManagedBean;
import br.com.oficina.util.MesagensUtil;


@ManagedBean
public class FerramentaBean {

    private Ferramenta ferramenta = new Ferramenta();
    private FerramentaDAO dao = new FerramentaDAO();

    public void salvar() {
        if (ferramenta.getId() == 0) {
            try {
                dao.salvar(ferramenta);
            } catch (Exception ex) {
                MesagensUtil.MessagemInfo(ex.getMessage());
                MesagensUtil.MessagemInfo("Registro salvo com sucesso!");
            }
        } else {
            dao.editar(ferramenta);
        }
        ferramenta = new Ferramenta();
    }

    public void excluir(Ferramenta ferramenta) {
        if (dao.excluir(ferramenta)) {
            MesagensUtil.MessagemInfo("Ferramenta excluido!");
        } else {
            MesagensUtil.MessagemErro("Ferramenta não excluido!");
        }

    }

    public void carregar(Ferramenta ferramenta) {
        this.ferramenta = ferramenta;
    }

    /**
     * @return the lista
     */
    public List<Ferramenta> getLista() {
        return dao.listar();
    }

    /**
     * @return the ferramenta
     */
    public Ferramenta getFerramenta() {
        return ferramenta;
    }

    /**
     * @param ferramenta the ferramenta to set
     */
    public void setFerramenta(Ferramenta ferramenta) {
        this.ferramenta = ferramenta;
    }

}
