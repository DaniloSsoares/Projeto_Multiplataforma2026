package io.github.fatec.introducao.service;

import io.github.fatec.introducao.model.Pessoa;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class PessoaService {
private Map<String, Pessoa> armazenamentoPessoa = new HashMap<>();

public Collection<Pessoa> listar(){
    return armazenamentoPessoa.values();
}

public Pessoa criar(Pessoa pessoa){
    String novoId = UUID.randomUUID().toString();
    pessoa.setId(novoId);
    armazenamentoPessoa.put(pessoa.getId(), pessoa);
    return pessoa;
}
public Pessoa atualizar(Pessoa pessoa){
    armazenamentoPessoa.put(pessoa.getId(), pessoa);
    return pessoa;
}

public boolean deletar(String id){
    if(armazenamentoPessoa.containsKey(id)){
        armazenamentoPessoa.remove(id);
        return true;
    }
    return false;
}

}
