package com.ianzyon.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ianzyon.cursomc.domain.Categoria;
import com.ianzyon.cursomc.repositories.CategoriaRepository;
import com.ianzyon.cursomc.services.exceptions.ObjectNotFoundException;



// classe usada para passar uma requisição de busca para o banco de dados buscando objetos da categoria
@Service
public class CategoriaService {
	
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) throws ObjectNotFoundException {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));	}

}

