package cl.aiep.java.catalogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.aiep.java.catalogo.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
