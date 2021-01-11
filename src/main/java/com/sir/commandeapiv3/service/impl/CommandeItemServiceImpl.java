/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.commandeapiv3.service.impl;

import com.sir.commandeapiv3.bean.Commande;
import com.sir.commandeapiv3.dao.CommandeDao;
import com.sir.commandeapiv3.dao.CommandeItemDao;
import com.sir.commandeapiv3.service.CommandeItemService;
import com.sir.commandeapiv3.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sir.commandeapiv3.bean.CommandeItem;
import java.util.List;

/**
 *
 * @author Makadji
 */

@Service
public class CommandeItemServiceImpl implements CommandeItemService{
   @Autowired
    private CommandeItemDao commandeItemDao;
    @Autowired
    private CommandeDao commandeDao;

    @Override
    public List<CommandeItem> findByCommandeReference(String reference) {
       return commandeItemDao.findByReferenceDemande(reference);
    }
   
    @Override
    public int saveCommandeItems(Commande commande, List<CommandeItem> commandeItems) {
      for(CommandeItem commandeItem : commandeItems){
          commandeItem.setCommande(commande);
          commandeItemDao.save(commandeItem);
      }
      return 1;
    }

    @Override
    public CommandeItem saveCommandeItem(CommandeItem commandeItem,String referenceCommande) {
       if(commandeItem!=null){
           Commande c= commandeDao.findByReference(referenceCommande);
           commandeItem.setCommande(c);
           commandeItemDao.save(commandeItem);
           return commandeItem;
          }
               return null;
       }
      
 }

