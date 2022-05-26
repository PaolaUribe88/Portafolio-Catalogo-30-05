package cl.aiep.java.catalogo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.aiep.java.catalogo.modelo.Categoria;
import cl.aiep.java.catalogo.repository.CategoriaRepository;



@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@GetMapping ("/index")//http://localhost:8081/ AL NO TENER UN ASIGNADO SE ABRE DESDE EL NAVEGADOR DIRECTAMENTE EN EL LOCALHOST
	public String index() {
	
		return "index";
	}
	//NUEVA CATEGORIA
	@GetMapping("/nuevo")
	private String nuevo(Categoria categoria) {
		return"/categoria/form";
	}
	//PROCESAR NUEVA CATEGORIA
	@PostMapping("/procesar")
	public String procesar(@Valid Categoria categoria, BindingResult informeValidacion) {
		if(informeValidacion.hasErrors()) return "categoria/form";
		//SI INFORME VALIDACION DA ERROR ENTONCES RETORNAR A FORMULARIO
		//SI NO DA ERROR CONTINUAR y guargar en categoria
		categoriaRepository.saveAndFlush(categoria);
		//ENTONCES RETORNAR A LISTADO DE CATEGORIA
		return "redirect:/categoria/listado";
	}
	//LISTAR CATEGORIA
	@GetMapping("/listado")
	public String listado(Model modelo) {
		List<Categoria> categorias = categoriaRepository.findAll();
		modelo.addAttribute("categorias", categorias);
		return "categoria/listado";
	}
	//EDITAR CATEGORIA
	@GetMapping("/editar/{id}")
	public String editarCategoria(@PathVariable(name = "id")Categoria categoria, Model modelo) {
		modelo.addAttribute("categoria", categoria);
		return "categoria/form";
	}
	//ELIMINAR CATEGORIA
	@GetMapping("/eliminar/{id}")
	public String eliminarCategoria(@PathVariable Long id) {
		categoriaRepository.deleteById(id);
		return "redirect:/categoria/listado";
	}
}

