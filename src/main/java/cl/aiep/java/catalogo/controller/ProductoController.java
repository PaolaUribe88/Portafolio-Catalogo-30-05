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
import cl.aiep.java.catalogo.modelo.Producto;
import cl.aiep.java.catalogo.repository.CategoriaRepository;
import cl.aiep.java.catalogo.repository.ProductoRepository;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	@Autowired
	ProductoRepository productoRepository;
	@Autowired
	CategoriaRepository categoriaRepository;
	
		@GetMapping ("/index")//http://localhost:8081/ AL NO TENER UN ASIGNADO SE ABRE DESDE EL NAVEGADOR DIRECTAMENTE EN EL LOCALHOST
		public String index() {
		
			return "index";
		}
		//NUEVO PRODUCTO
		@GetMapping("/nuevo")
		private String nuevo(Producto producto, Model modelo) {
			List<Categoria> categorias = categoriaRepository.findAll();
			modelo.addAttribute("categorias",categorias);
			return"/producto/form";
		}
		//PROCESAR NUEVO PRODUCTO
		@PostMapping("/procesar")
		public String procesar(@Valid Producto producto, BindingResult informeValidacion) {
			if(informeValidacion.hasErrors()) return "producto/form";
			//SI INFORME VALIDACION DA ERROR ENTONCES RETORNAR A FORMULARIO
			//SI NO DA ERROR CONTINUAR y guargar en producto
			productoRepository.saveAndFlush(producto);
			//ENTONCES RETORNAR A LISTADO DE CATEGORIA
			return "redirect:/producto/listado";
		}
		//LISTAR PRODUCTO
		@GetMapping("/listado")
		public String listado(Model modelo) {
			List<Producto> productos = productoRepository.findAll();
			modelo.addAttribute("productos", productos);
			return "producto/listado";
		}
		//EDITAR PRODUCTO
		@GetMapping("/editar/{id}")
		public String editarProducto(@PathVariable(name = "id")Producto producto, Model modelo) {
			List<Categoria>categorias= categoriaRepository.findAll();
			modelo.addAttribute("categorias",categorias);
			modelo.addAttribute("producto", producto);	
			return "producto/form";
		}
		//ELIMINAR PRODUCTO
		@GetMapping("/eliminar/{id}")
		public String eliminarProducto(@PathVariable Long id) {
			productoRepository.deleteById(id);
			return "redirect:/producto/listado";
		}
}
