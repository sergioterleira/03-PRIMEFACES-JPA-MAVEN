package com.sterleira.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.sterleira.model.Cliente;
import com.sterleira.model.JPAUtil;
import com.sterleira.model.Producto;

public class ClienteDAO {
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	// Guardamos el Cliente
	public void guardar(Cliente cliente) {
		entity.getTransaction().begin();
		entity.persist(cliente);
		entity.getTransaction().commit();
		// JPAUtil.shutdown();
	}

	// Editamos el cliente
	public void editar(Cliente cliente) {
		entity.getTransaction().begin();
		entity.merge(cliente);
		entity.getTransaction().commit();
		// JPAUtil.shutdown();
	}

	// buscar cliente
	public Cliente buscar(Long clienteId) {
		Cliente c = new Cliente();
		c = entity.find(Cliente.class, clienteId);
		// JPAUtil.shutdown();
		return c;
	}

	// eliminar clientes
	public void eliminar(Long clienteId) {
		Cliente c = new Cliente();
		c = entity.find(Cliente.class, clienteId);
		entity.getTransaction().begin();
		entity.remove(c);
		entity.getTransaction().commit();
	}

	// Obtener todos los clientes
	@SuppressWarnings("unchecked")
	public List<Cliente> obtenerClientes() {
		List<Cliente> listaClientes = new ArrayList<>();
		Query q = entity.createQuery("SELECT c FROM cliente c");
		listaClientes = q.getResultList();
		return listaClientes;
	}
	
	@SuppressWarnings("unchecked")
	public List<Producto> obtenerProductosDistintos(Long clienteId) {
		Query q = entity.createQuery("SELECT p FROM producto p WHERE NOT p.cliente.id = "+clienteId);
		List<Producto>  listaProductos = new ArrayList<>();
		listaProductos = q.getResultList();
		return listaProductos;
	}
	
	public List<Producto> obtenerProductosPropios(Long clienteId) {
		Cliente cliente = entity.find(Cliente.class, clienteId);
		List<Producto> productos = cliente.getProductos();
		return productos;
	}
	
	public void cerrarConexion() {
		JPAUtil.shutdown();
	}
}
