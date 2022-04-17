package br.unoesc.ads.pessoa.controllers;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.unoesc.ads.pessoa.entities.Pessoa;
import br.unoesc.ads.pessoa.repositories.PessoaRepository;

@Controller
@CrossOrigin(origins = "*")
public class PessoaController {
	@Autowired
	PessoaRepository pessoaRepository;

	@GetMapping("/pessoa")
	public String listarPessoa(Model model) {
		SimpleDateFormat dateFormat = new SimpleDateFormat();
		Calendar cal = Calendar.getInstance();
		String sDataAux;
		dateFormat.applyPattern("dd 'de' MMMM 'de' yyyy");
		sDataAux = dateFormat.format(cal.getTime());
	
		model.addAttribute("data", LocalDateTime.now());
		model.addAttribute("dataExtenso", "<b>" + sDataAux + "</b>");
		model.addAttribute("pessoa", pessoaRepository.findAll());
		return "lista_pessoa";
	}

	@GetMapping("/incluir_pessoa")
	public String formPessoa(Model model) {
		model.addAttribute("pessoa", new Pessoa());
		model.addAttribute("adicionar", true);
		return "form_pessoa";
	}

	@PostMapping("/processa_incluir_pessoa")
	public String processaFormIncluirPessoa(@Valid Pessoa pessoa, BindingResult resultado) {
		if (resultado.hasErrors()) {
			return "form_pessoa";
		}
		pessoaRepository.save(pessoa);
		return "redirect:/pessoa";
	}
	
	@GetMapping("/alterar_pessoa/{id}")
	public String alterar(@PathVariable("id") long id, Model model) {
		Pessoa pessoa = pessoaRepository.findById(id)
							.orElseThrow(() -> new IllegalArgumentException("Pessoa inválido Id:" + id));
		model.addAttribute("pessoa", pessoa);
		model.addAttribute("adicionar", false);
		return "form_pessoa";
	}
	
	@PostMapping("/processa_alterar_pessoa/{id}")
	public String processaFormAlterarPessoa(@PathVariable("id") long id, @Valid Pessoa pessoa, BindingResult resultado, Model model) {
		if (resultado.hasErrors()) {
			pessoa.setId(id);
			return "form_pessoa";
		}
		pessoaRepository.save(pessoa);
		return "redirect:/pessoa";
	}
	
	@GetMapping("/excluir_pessoa/{id}")
	public String remover(@PathVariable("id") long id, Model model) {
		Pessoa pessoa = pessoaRepository.findById(id).get();
		pessoaRepository.delete(pessoa);
		return "redirect:/pessoa";
	}
}
