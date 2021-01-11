/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.commandeapiv3.rest.converter;

import com.sir.commandeapiv3.bean.CommandeItem;
import com.sir.commandeapiv3.commun.util.NumberUtil;
import com.sir.commandeapiv3.rest.vo.CommandeItemVo;
import com.sir.commandeapiv3.rest.vo.CommandeVo;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Keita Moussa
 */
public class CommandeItemConverter extends AbstractConverter<CommandeItem, CommandeItemVo>{

    public CommandeItemConverter() {
    }

    @Override
    public CommandeItem toItem(CommandeItemVo vo) {
          if(vo!=null){
              CommandeItem commandeItem = new CommandeItem();
            commandeItem.setId(vo.getId());
            commandeItem.setReferenceDemande(vo.getReferenceDemande());
           
              return commandeItem;
          }
          return null;
    }

    @Override
    public CommandeItemVo toVo(CommandeItem item) {
        if(item!=null){
            CommandeItemVo vo = new CommandeItemVo();
            vo.setId(item.getId());
            vo.setReferenceDemande(item.getReferenceDemande());
            vo.setCommandeVo(new CommandeConverter().toVo(item.getCommande()));
            return vo;
        }
 return null;
    }
}
