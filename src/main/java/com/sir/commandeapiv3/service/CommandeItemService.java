/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.commandeapiv3.service;

import com.sir.commandeapiv3.bean.Commande;
import com.sir.commandeapiv3.bean.CommandeItem;
import java.util.List;

/**
 *
 * @author Makadji
 */
public interface CommandeItemService {
     public int saveCommandeItems(Commande commande, List<CommandeItem> commandeItems);
     public CommandeItem saveCommandeItem(CommandeItem commandeItem,String referenceCommande);
     public List<CommandeItem> findByCommandeReference(String reference);
}
