///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.sir.commandeapiv3.rest.proxy;
//
//import com.sir.commandeapiv3.rest.vo.exchange.ProduitVo;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
///**
// *
// * @author Keita Moussa
// */
//@FeignClient(name="microservice-produits", url="localhost:8099")
//public interface ProduitProxy {
//    @GetMapping("/produit_api/produit/reference/{reference}")
//    public ProduitVo findByReference(@PathVariable("reference") String reference);
//}
