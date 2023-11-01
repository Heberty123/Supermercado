package br.com.project.supermercado.services;

import br.com.project.supermercado.dtos.ProdutoDTO;
import br.com.project.supermercado.exceptions.NotFoundException;
import br.com.project.supermercado.models.Produto;
import br.com.project.supermercado.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<ProdutoDTO> pegarTodos(){
        List<ProdutoDTO> dtos = repository.findAll()
                .stream()
                .map(ProdutoDTO::new)
                .toList();

        if(dtos.isEmpty()){
            throw new NotFoundException("Não existe nenhum produtos no banco de dados !");
        }
        return dtos;
    }

    public ProdutoDTO pegarProdutoEspecifico(Long id){
        if(!repository.existsById(id)){
            throw new NotFoundException("O produto com id: " + id + " não existe!");
        }
        return new ProdutoDTO(repository.getReferenceById(id));
    }

    public ProdutoDTO cadastrar(Produto produto){
        return new ProdutoDTO(repository.save(produto));
    }

    public ProdutoDTO editar(Produto produto){
        if(!repository.existsById(produto.getId())){
            throw new NotFoundException("O produto com id: " + produto.getId() + " não existe!");
        }

        return new ProdutoDTO(repository.save(produto));
    }

    public void delete(Long id){
        if(!repository.existsById(id)){
            throw new NotFoundException("O produto com id: " + id + " não existe!");
        }

        repository.deleteById(id);
    }
}
