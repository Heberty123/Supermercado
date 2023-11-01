package br.com.project.supermercado.controllers;

import br.com.project.supermercado.dtos.ProdutoDTO;
import br.com.project.supermercado.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> pegarTodos(){
        List<ProdutoDTO> dtos = service.pegarTodos();

        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> pegarProdutoEspecifico(@PathVariable Long id){
        ProdutoDTO dto = service.pegarProdutoEspecifico(id);

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> cadastrar(@RequestBody ProdutoDTO dtoReceived){

        ProdutoDTO sendDto = service.cadastrar(dtoReceived.toProduto());
        return ResponseEntity.ok(sendDto);
    }

    @PutMapping
    public ResponseEntity<ProdutoDTO> editar(@RequestBody ProdutoDTO dtoReceived){

        ProdutoDTO sendDto = service.editar(dtoReceived.toProduto());
        return ResponseEntity.ok(sendDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProdutoDTO> delete(@PathVariable Long id){

        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
