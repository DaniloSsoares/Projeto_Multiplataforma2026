package io.github.fatec.service;

import io.github.fatec.entity.Pessoa;
import io.github.fatec.repository.pessoaRepository;

import java.util.Collection;

public class PessoaService {
    private final pessoaRepository repository;

    public PessoaService(pessoaRepository repository){
        this.repository = repository;
    }
    public Collection<Pessoa> listar(){
        return repository.listar();
    }
    public Pessoa criar(Pessoa pessoa){
        return repository.salvar(pessoa);
    }
    public Pessoa atualizar(Pessoa pessoa){
        return repository.atualizar(pessoa);
    }
    public boolean deletar(String id) {
        return repository.deletar(id);
    }
}
