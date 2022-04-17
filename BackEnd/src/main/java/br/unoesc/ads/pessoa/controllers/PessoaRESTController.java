package br.unoesc.ads.pessoa.controllers;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unoesc.ads.pessoa.dto.PessoaDTO;
import br.unoesc.ads.pessoa.entities.Pessoa;
import br.unoesc.ads.pessoa.repositories.PessoaRepository;
import br.unoesc.ads.pessoa.services.PessoaService;


@RestController
@RequestMapping(value="api")
public class PessoaRESTController {
@Autowired
private PessoaService servico;
@Autowired
private PessoaRepository repositorio;
@GetMapping(value = "/pessoa")
public Page<PessoaDTO> findAll(Pageable pageable) {
return servico.findAll(pageable);
}
@GetMapping(value = "/pessoa/{id}")
public PessoaDTO findById(@PathVariable Long id) {
return servico.findById(id);
}
// Incluir pessoa
@PostMapping("/pessoa")
public Pessoa salvarPessoa(@RequestBody Pessoa pessoa) {
return repositorio.save(pessoa);
}
// Atualizar pessoa
@PutMapping("/pessoa")
public Pessoa atualizarPessoa(@RequestBody Pessoa pessoa) {
return repositorio.save(pessoa);
}
@DeleteMapping("/pessoa")
public void deletarPessoa(@RequestBody Pessoa pessoa) {
repositorio.delete(pessoa);
}
@GetMapping(value={"/pessoaporidade", "/pessoaporidade/{idade}"})
public List<Pessoa> listarPorIdade(@PathVariable Optional<BigDecimal> idade) {
return repositorio.porIdade(idade.orElse(BigDecimal.ZERO));
}
}