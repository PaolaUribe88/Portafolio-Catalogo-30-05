package cl.aiep.java.catalogo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity //CONFIGURA BD
public class Categoria {
	
	@Id //SETEA LLAVE PRIMARIA
	@GeneratedValue(strategy = GenerationType.AUTO)//ID AUTOINCREMENTAL
	private Long id;
	@Column(nullable = false, length = 50)	
	private String nombre;
	
	//CONSTRUCTOR VACIO
	public Categoria() {
		super();
	}
	//CONSTRUCTOR COMPLETO
	public Categoria(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
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
	
}
