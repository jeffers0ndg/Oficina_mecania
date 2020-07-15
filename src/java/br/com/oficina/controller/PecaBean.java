package br.com.oficina.controller;

import br.com.oficina.dao.PecaDAO;
import br.com.oficina.model.Peca;
import java.util.List;
import javax.faces.bean.ManagedBean;
import br.com.oficina.util.MesagensUtil;


@ManagedBean
public class PecaBean {

    private Peca peca = new Peca();
    private PecaDAO dao = new PecaDAO();

    public void salvar() {
        if (peca.getId() == 0) {
            try {
                dao.salvar(peca);
            } catch (Exception ex) {
                MesagensUtil.MessagemInfo(ex.getMessage());
                MesagensUtil.MessagemInfo("Peça salva com sucesso!");
            }
        } else {
            dao.editar(peca);
        }
        peca = new Peca();
    }

    public void excluir(Peca peca) {
        if (dao.excluir(peca)) {
            MesagensUtil.MessagemInfo("Peça excluido!");
        } else {
            MesagensUtil.MessagemErro("Peça não excluido!");
        }

    }

    public void carregar(Peca peca) {
        this.peca = peca;
    }

    /**
     * @return the lista
     */
    public List<Peca> getLista() {
        return dao.listar();
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }

}
