package io.github.fatec.introducao.service;

import io.github.fatec.introducao.model.Pessoa;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class PessoaService {
private Map<Long, Pessoa> armazenamentoPessoa = new HashMap<>();
private Long proximoId =1L;

public Collection<Pessoa> listar(){
    return armazenamentoPessoa.values();
}

public Pessoa criar(Pessoa pessoa){
    pessoa.setId(proximoId++);
    armazenamentoPessoa.put(pessoa.getId(), pessoa);
    return pessoa;
}
public Pessoa atualizar(Pessoa pessoa){
    armazenamentoPessoa.put(pessoa.getId(), pessoa);
    return pessoa;
}

public boolean deletar(Long id){
    if(armazenamentoPessoa.containsKey(id)){
        armazenamentoPessoa.remove(id);
        return true;
    }
    return false;
}

}
