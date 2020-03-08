package com.moises.APIconceito.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.moises.APIconceito.domain.Produto;
import com.moises.APIconceito.dto.ProdutoDTO;
import com.moises.APIconceito.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repo;
	
	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getSimpleName(), null));
	}
	
	public Produto insert(Produto obj) {
		obj.setCodigo(null);
		return repo.save(obj);
	}
	
	public Produto update(Produto obj) {
		Produto newObj = find(obj.getCodigo());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
		repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possível excluir este produto!");
		}
	}
	
	public List<Produto> findAll(){
		return repo.findAll();
	}
	
	public Page<Produto> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		return repo.findAll(pageRequest);
	}
	
	public Produto fromDTO(ProdutoDTO objDto) {
		return new Produto(objDto.getCodigo(), objDto.getDescricao(), objDto.getValor(), objDto.getQuantidade());
	}
	
	private void updateData(Produto newObj, Produto obj) {
		newObj.setDescricao(obj.getDescricao());
		newObj.setValor(obj.getValor());
		newObj.setQuantidade(obj.getQuantidade());
	}

}
