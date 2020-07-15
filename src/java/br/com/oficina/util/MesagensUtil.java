package br.com.oficina.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


public class MesagensUtil {

    public static void MessagemInfo(String msg) {
        FacesMessage msgs = new FacesMessage(msg);
        FacesContext.getCurrentInstance().addMessage(null, msgs);
    }

    public static void MessagemErro(String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, "Erro"));
    }

    public static void MessagemAviso(String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, msg, "Atenção"));
    }
}
