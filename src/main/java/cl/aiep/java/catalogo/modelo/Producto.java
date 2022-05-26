package cl.aiep.java.catalogo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity //CONFIGURA BD
public class Producto {

	@Id //SETEA LLAVE PRIMARIA
	@GeneratedValue(strategy = GenerationType.AUTO)//ID AUTOINCREMENTAL
	private Long id;
	@Column(nullable = false, length = 50)
	private String nombre;
	@Column(nullable = false, length = 100)
	private String descripcion;
	@Column(nullable = false, length = 100)
	private String marca;
	@ManyToOne
	private Categoria categoria;
	
	//CONSTRUCTOR VACIO
	public Producto() {
		super();
	}
	//CONSTRUCTOR COMPLETO
	public Producto(Long id, String nombre, String descripcion, String marca, Categoria categoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.marca = marca;
		this.categoria = categoria;
	}
	
	//GETTER Y SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	
	
	
}
