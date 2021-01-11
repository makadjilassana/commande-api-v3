/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.commandeapiv3.rest;

import com.sir.commandeapiv3.bean.Commande;
import com.sir.commandeapiv3.bean.CommandeItem;
import com.sir.commandeapiv3.rest.converter.CommandeConverter;
import com.sir.commandeapiv3.rest.vo.CommandeVo;
import com.sir.commandeapiv3.service.CommandeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Makadji
 */
@RestController()/* indique que la class est un controller REST :Spring sait alors que les réponses 
aux requêtes qu'il vous passe devront
être très probablement en format JSON.*/
@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
@RequestMapping("/commande-api-v3/commandes")//lien entre l'uri et la methode//

public class CommandeRest {
    @Autowired
    private CommandeService commandeService;
    
     @PostMapping("/")
    public int creer(@RequestBody Commande commande) {
        return commandeService.creer(commande);
    }
    
    @PostMapping("/liste/")
    public Commande saveCommandeWithCommandeItems(@RequestBody Commande commande){
        return commandeService.saveCommandeWithCommandeItems(commande);
    }

    @GetMapping("/listeCommandes/")
    public List<Commande> afficherCommandes(){
        return commandeService.afficherCommandes();
    }
    
    @DeleteMapping("/liste/{reference}")
    public int deleteCommandeWithCommandeItems(@PathVariable("reference") String reference){
        return commandeService.deleteCommandeWithCommandeItems(reference);
    }
    
    @DeleteMapping("/reference/{reference}")
    public int deleteCommande(@PathVariable String reference){
        return commandeService.delete(reference);
    }
    
    @GetMapping("reference/{reference}")
    public Commande findByReference(@PathVariable String reference) {
       return commandeService.findByReference(reference);
    }
    @PutMapping("reference/{reference}/montant/{montant}")
    public int payer(@PathVariable("reference") String reference, @PathVariable("montant") double montant) {
        return commandeService.payer(reference, montant);
    }

    
}
