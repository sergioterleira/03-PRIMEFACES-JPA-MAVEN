package com.sterleira.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.sterleira.model.JPAUtil;
import com.sterleira.model.Producto;

public class ProductoDAO {
	
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	// Guardamos el Producto
	public void guardar(Producto producto) {
		entity.getTransaction().begin();
		entity.persist(producto);
		entity.getTransaction().commit();
		// JPAUtil.shutdown();
	}

	// Editamos el producto
	public void editar(Producto producto) {
		entity.getTransaction().begin();
		entity.merge(producto);
		entity.getTransaction().commit();
		// JPAUtil.shutdown();
	}

	// buscar producto
	public Producto buscar(Long productoId) {
		Producto c = new Producto();
		c = entity.find(Producto.class, productoId);
		// JPAUtil.shutdown();
		return c;
	}
	
	// eliminar productos
	public void eliminar(Long productoId) {
		Producto c = new Producto();
		c = entity.find(Producto.class, productoId);
		entity.getTransaction().begin();
		entity.remove(c);
		entity.getTransaction().commit();
	}

	// Obtener todos los productos
	@SuppressWarnings("unchecked")
	public List<Producto> obtenerProductos() {
		List<Producto> listaproductos = new ArrayList<>();
		Query q = entity.createQuery("SELECT c FROM producto c");
		listaproductos = q.getResultList();
		return listaproductos;
	}
	
	public void cerrarConexion() {
		JPAUtil.shutdown();
	}
}
