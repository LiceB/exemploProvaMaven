package br.fiap.app.exemplo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.fiap.app.exemplo.models.Categoria;
import br.fiap.app.exemplo.models.Fornecedor;
import br.fiap.app.exemplo.models.Produto;
import br.fiap.app.exemplo.repositories.FornecedorRepository;

@Controller
@RequestMapping("/fornecedor")
public class FornecedorController {
	
	@Autowired //injeção de dependência
	private FornecedorRepository fornecedorRepository; 
	

	@GetMapping("")
	public ModelAndView get() {
		ModelAndView model = new ModelAndView("fornecedor/index");
		
		List<Fornecedor> listaFornecedor = fornecedorRepository.findAll();
		
		model.addObject("fornecedores", listaFornecedor);
		return model;
	}
	
	@GetMapping("/edit/{id}")
	public String getById(Model model, @PathVariable("id")Integer idFornecedor) {
		model.addAttribute("idFornecedor", idFornecedor);
		return "fornecedor/edit";
	}
	
	@GetMapping("/create")
	public ModelAndView create() {
		ModelAndView model = new ModelAndView("fornecedor/create");
		return model;
	}
	
	@PostMapping("/create")
	public String create(@ModelAttribute("fornecedor")Fornecedor objFornecedor) {
		fornecedorRepository.save(objFornecedor);
		
		return "redirect:/fornecedor";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id")Long id) {
		fornecedorRepository.deleteById(id);
		return "redirect:/fornecedor";
	}
}
