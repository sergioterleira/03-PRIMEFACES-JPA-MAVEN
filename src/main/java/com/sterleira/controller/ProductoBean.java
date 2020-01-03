package com.sterleira.controller;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.sterleira.dao.ProductoDAO;
import com.sterleira.model.Producto;

@ManagedBean(name = "productoBean")
@RequestScoped // Ambito del bean
public class ProductoBean {
	public String nuevo() {
		Producto c = new Producto();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("producto", c);
		return "/faces/nuevoProducto.xhtml";
	}
	
	public String guardar(Producto Producto) {
		ProductoDAO ProductoDAO = new ProductoDAO();
		ProductoDAO.guardar(Producto);
		return "/faces/productos.xhtml";
	}
	
	public List<Producto> obtenerProductos(){
		ProductoDAO ProductoDAO = new ProductoDAO();
		return ProductoDAO.obtenerProductos();		
	}
	
	public String editar(Long id) {
		ProductoDAO ProductoDAO = new ProductoDAO();
		Producto p = new Producto();
		p = ProductoDAO.buscar(id);
		System.out.println(p);
		
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("producto", p);
		return "/editarProducto.xhtml";
	}
	
	public String actualizar(Producto Producto) {
		ProductoDAO ProductoDAO = new ProductoDAO();
		ProductoDAO.editar(Producto);
		return "/faces/productos.xhtml";
	}
	
	public String eliminar(Long id) {
		ProductoDAO ProductoDAO = new ProductoDAO();
		ProductoDAO.eliminar(id);
		System.out.print("Producto eliminado perfectamente");
		return "/faces/productos.xhtml";
	}
}
