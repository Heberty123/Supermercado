package br.com.project.supermercado.dtos;

import br.com.project.supermercado.models.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {

    private Long id;

    private String nome;

    private Double valor;

    public Produto toProduto(){
        return new Produto(id, nome, valor);
    }

    public ProdutoDTO(Produto produto){
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.valor = produto.getValor();
    }
}
