/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.commandeapiv3.rest.converter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Keita Moussa
 */
public abstract class AbstractConverter <T,Vo>{//pour exiger la meme notation//
    public abstract Vo toVo(T item);
    public abstract T toItem(Vo vo);
    
        //convertion de la listeItem//
    
    public  List<T> toItem(List<Vo> vos){
        if(vos==null || vos.isEmpty()){
            return null; 
        }
        else{
            //on cree une liste et bouclé sur la liste apres ajouter à la liste//
            List<T> list= new ArrayList();
            for(Vo vo : vos){
                list.add(toItem(vo));
            }
            return list;
        }
    }
     public  List<Vo> toVo(List<T> items){
                 if(items==null || items.isEmpty()){
            return null; 
                    }
        else{
            //on cree une liste et bouclé sur la liste apres ajouter à la liste//
            List<Vo> list= new ArrayList();
            for(T item   : items){
                list.add(toVo(item));
            }
            return list;
        }
         
     }
}
