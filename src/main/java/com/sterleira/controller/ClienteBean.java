package com.sterleira.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.sterleira.dao.ClienteDAO;
import com.sterleira.model.Cliente;
import com.sterleira.model.Producto;

@ManagedBean(name = "clienteBean")
@RequestScoped // Ambito del bean
public class ClienteBean {
	
	public String nuevo() {
		Cliente c = new Cliente();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("cliente", c);
		return "/faces/nuevoCliente.xhtml";
	}
	
	public String guardar(Cliente cliente) {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.guardar(cliente);
		return "/faces/clientesxhtml";
	}
	
	public List<Cliente> obtenerClientes(){
		ClienteDAO clienteDAO = new ClienteDAO();
		return clienteDAO.obtenerClientes();		
	}
	
	public List<Producto> getProductDistin(Long clienteId){
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Producto> p = new ArrayList<>();
		p = clienteDAO.obtenerProductosDistintos(clienteId);
		p.size();
		return p;
	}
	
	public String obtenerProductosPropios(Long clienteId){
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente c = new Cliente();
		c = clienteDAO.buscar(clienteId);
		
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("cliente", c);
		return "/faces/productosPropios.xhtml";
	}
	
	public String obtenerProductosDistintos(Long clienteId){
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente c = new Cliente();
		c = clienteDAO.buscar(clienteId);
		
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("cliente", c);
		return "/faces/productosDistintos.xhtml";
	}
	
	public String editar(Long clienteId) {
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente c = new Cliente();
		c = clienteDAO.buscar(clienteId);
		System.out.println(c);
		
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("cliente", c);
		return "/faces/editarCliente.xhtml";
	}

	public String actualizar(Cliente cliente) {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.editar(cliente);
		return "/faces/clientes.xhtml";
	}
	
	public String eliminar(Long id) {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.eliminar(id);
		System.out.print("Cliente eliminado perfectamente");
		return "/faces/clientes.xhtml";
	}
}
