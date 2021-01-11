/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.commandeapiv3.service.impl;

import com.sir.commandeapiv3.bean.Commande;
import com.sir.commandeapiv3.bean.CommandeItem;
import com.sir.commandeapiv3.dao.CommandeDao;
import com.sir.commandeapiv3.dao.CommandeItemDao;
import com.sir.commandeapiv3.service.CommandeItemService;
import com.sir.commandeapiv3.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 *
 * @author Makadji
 */
@Service
public class CommandeServiceImpl implements CommandeService{
    
    @Autowired
     private CommandeDao commandeDao;
    @Autowired
     private CommandeItemDao commandeItemDao;
    @Autowired
    private CommandeItemService commandeItemService;
    
     @Override
    public Commande saveCommandeWithCommandeItems(Commande commande) {
        commandeDao.save(commande); 
        commandeItemService.saveCommandeItems(commande, commande.getCommandeItems());
        return commande;
    }
    
    @Override
    public int deleteCommandeWithCommandeItems(String reference){
        Commande c= commandeDao.findByReference(reference);
        if(c!=null){
            for(CommandeItem commandeItem:c.getCommandeItems()){
                commandeItemDao.delete(commandeItem);
            }
            commandeDao.delete(c);
            return 1;
        }
        return -1;
    }
    
          @Override
    public int creer(Commande commande) {
       Commande c = findByReference(commande.getReference());
       if(c!=null){
           return -1;
       }
      else {
      commandeDao.save(commande);
      return 1;
      }
 }
    
    public Commande findByReference(String reference) {
        
        return commandeDao.findByReference(reference);
       
    }
    
     @Override
    public int delete(String reference) {
        
        Commande c = findByReference(reference);
       if(c==null){
           return -1;
       }
      else {
      commandeDao.delete(c);
      return 1;
      }
        
  }

    @Override
    public int payer(String reference, double montant) {
       Commande commande = findByReference(reference);
       if(commande==null){
           return -1;
       }
       else if(commande.getTotalPaiement()+montant > commande.getTotal()){
           return -2;
       }
       else{
           double nvPaiement = commande.getTotalPaiement()+montant;
           commande.setTotalPaiement(nvPaiement);
           commandeDao.save(commande);
 
           return 1;
       }
}
   @Override
    public List<Commande> afficherCommandes(){
         return commandeDao.findAll();
    }

/*    private void calculerTotalCommande(Commande commande , List<CommandeItem> commandeItems) {
        double total=0D;
        if(commandeItems!=null){
       for(CommandeItem commandeItem : commandeItems){
           total+=commandeItem.getPrix()*commandeItem.getQuantite();
        }
        }
         commande.setTotal(total);
   }  */

}
