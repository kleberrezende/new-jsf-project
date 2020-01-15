package br.com.virtualab.app.entity.configuracoes;

import br.com.virtualab.app.entity.Abstract.AbstractEntity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Configuracoes extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Transient
    private final int temaSistemaSize = 20;
    @Column(length = temaSistemaSize, nullable = false)
    private String temaSistema = "aristo";

    public String getTemaSistema() {
        return temaSistema;
    }

    public void setTemaSistema(String temaSistema) {
        this.temaSistema = temaSistema;
    }

    public int getTemaSistemaSize() {
        return temaSistemaSize;
    }
    
}
