package br.com.oficina.controller;

import br.com.oficina.dao.UsuarioDAO;
import br.com.oficina.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import br.com.oficina.util.MesagensUtil;


@ManagedBean
public class UsuarioBean {

    private String repetirSenha;
    private Usuario usuario = new Usuario();
    private List<String> cidades = new ArrayList<>();
    private UsuarioDAO dao = new UsuarioDAO();

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the repetirSenha
     */
    public String getRepetirSenha() {
        return repetirSenha;
    }

    /**
     * @param repetirSenha the repetirSenha to set
     */
    public void setRepetirSenha(String repetirSenha) {
        this.repetirSenha = repetirSenha;
    }

    public void salvar() {
        if (usuario.getSenha().equals(repetirSenha)) {
            if (usuario.getId() == 0) {
                try {
                    dao.salvar(usuario);
                } catch (Exception ex) {
                    MesagensUtil.MessagemInfo(ex.getMessage());
                }
            } else {
                dao.editar(usuario);
            }
            usuario = new Usuario();
            MesagensUtil.MessagemInfo("Registro salvo com sucesso!");
        } else {
            MesagensUtil.MessagemInfo("As senhas nÃ£o conferem!");
        }
    }

    public void excluir(Usuario usuario) {
        if (dao.excluir(usuario)) {
            MesagensUtil.MessagemInfo("Usuario excluido!");
        } else {
            MesagensUtil.MessagemErro("Usuario nÃ£o excluido!");
        }

    }

    public void carregar(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the lista
     */
    public List<Usuario> getLista() {
        return dao.listar();
    }

    /**
     * @return the cidades
     */
    public List<String> getCidades() {
        if (cidades.isEmpty()) {
            cidades.add("Patos");
            cidades.add("Vista Serrana");
            cidades.add("Malta");
        }
        return cidades;
    }

    /**
     * @param cidades the cidades to set
     */
    public void setCidades(List<String> cidades) {
        this.cidades = cidades;
    }

}
