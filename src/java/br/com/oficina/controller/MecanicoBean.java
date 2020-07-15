package br.com.oficina.controller;

import br.com.oficina.dao.MecanicoDAO;
import br.com.oficina.model.Mecanico;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import br.com.oficina.util.MesagensUtil;


@ManagedBean
public class MecanicoBean {

    private Mecanico mecanico = new Mecanico();
    private List<String> bairros = new ArrayList<>();
    private MecanicoDAO dao = new MecanicoDAO();

    /**
     * @return the mecanico
     */
    public Mecanico getMecanico() {
        return mecanico;
    }

    /**
     * @param mecanico the mecanico to set
     */
    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

    public void salvar() {
        if (mecanico.getId() == 0) {
            try {
                dao.salvar(mecanico);
            } catch (Exception ex) {
                MesagensUtil.MessagemInfo(ex.getMessage());
                MesagensUtil.MessagemInfo("Registro salvo com sucesso!");
            }
        } else {
            dao.editar(mecanico);
        }
        mecanico = new Mecanico();

    }

    public void excluir(Mecanico mecanico) {
        if (dao.excluir(mecanico)) {
            MesagensUtil.MessagemInfo("Mecanico excluido!");
        } else {
            MesagensUtil.MessagemErro("Mecanico não excluido!");
        }

    }

    public void carregar(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

    /**
     * @return the lista
     */
    public List<Mecanico> getLista() {
        return dao.listar();
    }

    /**
     * @return the cidades
     */
    public List<String> getBairros() {
        if (bairros.isEmpty()) {
            bairros.add("Centro");
            bairros.add("Brasilia");
            bairros.add("Santo Antonio");
            bairros.add("Belo Horizonte");
            bairros.add("Bela Vista");
            bairros.add("Bivar Olinto");
            bairros.add("Morada do sol");
        }
        return bairros;
    }

    /**
     * @param cidades the cidades to set
     */
    public void setBairros(List<String> cidades) {
        this.bairros = cidades;
    }

}
