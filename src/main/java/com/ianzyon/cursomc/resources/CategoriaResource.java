package com.ianzyon.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ianzyon.cursomc.domain.Categoria;
import com.ianzyon.cursomc.services.CategoriaService;
import com.ianzyon.cursomc.services.exceptions.ObjectNotFoundException;



// Classe usada para passar um request http contendo os paths da REST
@RestController 
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) throws ObjectNotFoundException {
		Categoria obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}
