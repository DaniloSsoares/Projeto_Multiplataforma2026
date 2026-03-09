package io.github.fatec.repository.adapter;

import io.github.fatec.entity.Pessoa;
import io.github.fatec.repository.orm.pessoaOrmMongo;

public class pessoaRepositoryAdapter {
    private pessoaRepositoryAdapter(){}
        public static Pessoa castOrm(pessoaOrmMongo orm) {
            return new Pessoa(
                    orm.id(),
                    orm.nome(),
                    orm.endereco(),
                    orm.telefone());
        }

        public static pessoaOrmMongo castEntity(Pessoa entity) {
            return new pessoaOrmMongo(
                    entity.id(),
                    entity.nome(),
                    entity.endereco(),
                    entity.telefone());
        }
    }
