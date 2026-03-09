package io.github.fatec.repository.mongo;


import io.github.fatec.repository.orm.pessoaOrmMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface pessoaRepositoryWithMongoDB extends MongoRepository<pessoaOrmMongo, String> {
}
