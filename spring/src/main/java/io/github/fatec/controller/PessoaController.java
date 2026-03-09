package io.github.fatec.controller;

import io.github.fatec.controller.adapter.pessoaControllerAdapter;
import io.github.fatec.controller.dto.request.pessoaRequest;
import io.github.fatec.controller.dto.response.pessoaResponse;
import io.github.fatec.entity.Pessoa;
import io.github.fatec.repository.pessoaRepository;
import io.github.fatec.service.PessoaService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaService service;

    public PessoaController(PessoaService service) {
        this.service = service;
    }

    @GetMapping
    public Collection<pessoaResponse> listar() {

        return service.listar()
                .stream()
                .map(pessoaControllerAdapter::castResponse)
                .collect(Collectors.toList());
    }

    @PostMapping
    public pessoaResponse criar(@RequestBody pessoaRequest request) {

        Pessoa pessoa = pessoaControllerAdapter.castRequest(request);

        Pessoa salvar = service.criar(pessoa);

        return pessoaControllerAdapter.castResponse(salvar);
    }

    @PutMapping("/{id}")
    public pessoaResponse atualizar(@PathVariable String id, @RequestBody pessoaRequest request) {
        Pessoa pessoa = new Pessoa(id, request.nome(), request.endereco(), request.telefone());
        Pessoa atualizada = service.atualizar(pessoa);

        return pessoaControllerAdapter.castResponse(atualizada);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable String id) {
        boolean excluiu = service.deletar(id);
        if (excluiu) {
            return "Pessoa " + id + " deletada com sucesso!";
        }
        return "Pessoa não encontrada.";
    }
}
