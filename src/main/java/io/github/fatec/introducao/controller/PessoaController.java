package io.github.fatec.introducao.controller;

import io.github.fatec.introducao.model.Pessoa;
import io.github.fatec.introducao.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    @Autowired
    private PessoaService service;

    @GetMapping
    public Collection<Pessoa> getPessoas() {
        return service.listar();
    }

    @PostMapping
    public Map<String, Object> criar(@RequestBody Pessoa pessoa){
        Pessoa criar = service.criar(pessoa);

        Map<String, Object> resposta = new HashMap<>();
        resposta.put("id", criar.getId());
        resposta.put("nome", criar.getNome());

        return resposta;
    }
    @PutMapping("/{id}")
    public Map<String, Object> atualizar(@PathVariable String id, @RequestBody Pessoa pess) {
        pess.setId(id);
        Pessoa atualizada = service.atualizar(pess);

        Map<String, Object> resposta = new HashMap<>();
        resposta.put("id", atualizada.getId());
        resposta.put("nome", atualizada.getNome());

        return resposta;
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable String id) {
        boolean excluiu = service.deletar(id);
        if (excluiu) {
            return "usuario " + id + " deletado";
        }
        return "usuario não encontrado";
    }
}