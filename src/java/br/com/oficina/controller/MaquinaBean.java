package br.com.oficina.controller;

import br.com.oficina.dao.MaquinaDAO;
import br.com.oficina.model.Maquina;
import java.util.List;
import javax.faces.bean.ManagedBean;
import br.com.oficina.util.MesagensUtil;


@ManagedBean
public class MaquinaBean {

    private Maquina maquina = new Maquina();
    private MaquinaDAO dao = new MaquinaDAO();

    public void salvar() {
        if (getMaquina().getId() == 0) {
            try {
                dao.salvar(getMaquina());
            } catch (Exception ex) {
                MesagensUtil.MessagemInfo(ex.getMessage());
                MesagensUtil.MessagemInfo("Registro salvo com sucesso!");
            }
        } else {
            dao.editar(getMaquina());
        }
        setMaquina(new Maquina());
    }

    public void excluir(Maquina maquina) {
        if (dao.excluir(maquina)) {
            MesagensUtil.MessagemInfo("Maquina excluido!");
        } else {
            MesagensUtil.MessagemErro("Maquina não excluido!");
        }

    }

    public void carregar(Maquina maquina) {
        this.setMaquina(maquina);
    }

    /**
     * @return the lista
     */
    public List<Maquina> getLista() {
        return dao.listar();
    }

    /**
     * @return the maquina
     */
    public Maquina getMaquina() {
        return maquina;
    }

    /**
     * @param maquina the maquina to set
     */
    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

}
