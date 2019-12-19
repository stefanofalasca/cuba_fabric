package it.osl.jscomponent.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "JSCOMPONENT_PRODOTTO")
@Entity(name = "jscomponent_Prodotto")
public class Prodotto extends StandardEntity {
    private static final long serialVersionUID = 5584959048286304528L;

    @Column(name = "CODICE")
    protected String codice;

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }
}