/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.commandeapiv3.rest.vo;

import java.util.Date;

/**
 *
 * @author Keita Moussa
 */
public class CommandeItemVo {
    private Long id;
    private String referenceDemande; 
    private CommandeVo commandeVo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferenceDemande() {
        return referenceDemande;
    }

    public void setReferenceDemande(String referenceDemande) {
        this.referenceDemande = referenceDemande;
    }
    
    

    public CommandeVo getCommandeVo() {
        return commandeVo;
    }

    public void setCommandeVo(CommandeVo commandeVo) {
        this.commandeVo = commandeVo;
    }
    
    
}
