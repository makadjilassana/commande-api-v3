/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.commandeapiv3.proxy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 *
 * @author Makadji
 */

public interface ClientProxy {
    @GetMapping("/cni/{cni}")
    public int creerClient(@PathVariable("cni") Long cni);
}
