/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.commandeapiv3.rest.converter;

import com.sir.commandeapiv3.bean.Commande;
import com.sir.commandeapiv3.bean.CommandeItem;
import com.sir.commandeapiv3.commun.util.NumberUtil;
import com.sir.commandeapiv3.rest.vo.CommandeVo;
import java.util.List;

/**
 *
 * @author Keita Moussa
 */
public class CommandeConverter extends AbstractConverter<Commande , CommandeVo> {

    @Override
    public Commande toItem(CommandeVo vo) {
        Commande commande = new Commande();
        
        if(vo!=null)
        {
            commande.setId(vo.getId());
            commande.setReference(vo.getReference());
//            commande.setTotal(NumberUtil.toDouble(vo.getTotal()));
//            commande.setTotalPaiement(NumberUtil.toDouble(vo.getTotalPaiement()));
            commande.setCommandeItems(new CommandeItemConverter().toItem( vo.getCommandeItemVo()));
            return commande;
        }
      return null;
    }

    @Override
    public CommandeVo toVo(Commande item) {
        CommandeVo commandeVo = new CommandeVo();
        
         if(item!=null){
             commandeVo.setId(item.getId());
             commandeVo.setReference(item.getReference());
//             commandeVo.setTotalPaiement(NumberUtil.toBigString(item.getTotalPaiement()));
//             commandeVo.setTotal(NumberUtil.toBigString(item.getTotal()));
            // commandeVo.setCommandeItemVo(new CommandeItemConverter().toVo(item.getCommandeItems()));
             return commandeVo;
         }
         return null;
    }
//    public CommandeVo toVoo(Commande item) {
//         return null;
//    }
}
