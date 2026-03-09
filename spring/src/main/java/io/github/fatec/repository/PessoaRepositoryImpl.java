package io.github.fatec.repository;

import io.github.fatec.entity.Pessoa;
import io.github.fatec.repository.adapter.pessoaRepositoryAdapter;
import io.github.fatec.repository.mongo.pessoaRepositoryWithMongoDB;
import io.github.fatec.repository.orm.pessoaOrmMongo;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class PessoaRepositoryImpl implements pessoaRepository {
    private final pessoaRepositoryWithMongoDB mongoRepository;

    public PessoaRepositoryImpl(pessoaRepositoryWithMongoDB mongoRepository) {
        this.mongoRepository = mongoRepository;
    }

    @Override
    public Collection<Pessoa> listar() {
        return mongoRepository.findAll()
                .stream()
                .map(pessoaRepositoryAdapter::castOrm)
                .collect(Collectors.toList());
    }

    @Override
    public Pessoa salvar(Pessoa pessoa) {
        pessoaOrmMongo orm = pessoaRepositoryAdapter.castEntity(pessoa);
        pessoaOrmMongo salvo = mongoRepository.save(orm);
        return pessoaRepositoryAdapter.castOrm(salvo);
    }

    @Override
    public Pessoa atualizar(Pessoa pessoa) {
        return salvar(pessoa);
    }

    @Override
    public boolean deletar(String id) {
        if (mongoRepository.existsById(id)) {
            mongoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
