package com.udemy.myapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.myapi.domain.Usuario;
import com.udemy.myapi.repositories.UsuarioRepository;
import com.udemy.myapi.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public Usuario findById(Integer id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrato! ID:" + id + ", Tipo: " + Usuario.class.getName()));
	}

}
