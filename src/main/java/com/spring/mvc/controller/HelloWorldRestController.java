package com.spring.mvc.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mvc.model.ValidaNif;
import com.spring.mvc.service.MSValidaNifService;
import com.spring.mvc.util.Validador;

@CrossOrigin(origins = { "*" }, maxAge = 3000)
@RestController
public class HelloWorldRestController {
 
    @Autowired
    MSValidaNifService validaNifService;  //Service which will do all data retrieval/manipulation work
 
    
    //-------------------Retrieve Single User--------------------------------------------------------
     
    @RequestMapping(value = "/valida/{nif}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getUser(@PathVariable("nif") String nif) throws Exception {
        System.out.println("validar nif = " + nif);
                
        Validador val = new Validador();
        boolean ret = val.isvalido(nif);
        System.out.println("HelloWorldRestController.getUser() resultado de validacion = "+ret);
        if( ret) {
        	//NIF_OK validacion correcta damos de alta en la tabla de validaciones
            System.out.println("validacion correcta de nif = " + nif);
            ValidaNif validanif = new ValidaNif();
            validanif.setNif(nif);
            validanif.setResultado(String.valueOf(ret));
            validaNifService.altaValidacion(validanif);
            return new ResponseEntity<String>(String.valueOf(ret), HttpStatus.OK);
        
        }        
     
        return new ResponseEntity<String>(String.valueOf(ret), HttpStatus.OK);
    } 
 

 
}