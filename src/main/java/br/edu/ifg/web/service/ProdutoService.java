package br.edu.ifg.web.service;

import br.edu.ifg.web.data.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository repository;

    public List<Produto> listar() {
        return repository.findAll();
    }

    public void criar(Produto novo) {
        repository.save(novo);
    }

    public Produto obter(int id) {
        return repository.getOne(id);
    }

    public void excluir(int id) {
        repository.deleteById(id);
    }
}
