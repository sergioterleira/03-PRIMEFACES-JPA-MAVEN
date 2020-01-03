package com.sterleira.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "cliente")
@Table(name = "CLIENTES")
@NamedQueries({ @NamedQuery(name = "clienteFindAll", query = "SELECT c FROM cliente c"),
@NamedQuery(name = "clienteFindById", query = "SELECT c FROM cliente c WHERE c.id LIKE :id"),
@NamedQuery(name = "clienteFindByName", query = "SELECT c FROM cliente c WHERE c.nombres LIKE :nombre") })
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Indicamos que se generará la clave automaticamente en
														// SQLServer
	private Long id;

	@Column(name = "nombres")
	private String nombres;

	@OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
	private List<Producto> productos = new ArrayList<>();
	

	public Cliente() {
		super();
	}

	public Cliente(String nombres) {
		super();
		this.nombres = nombres;
	}

	public Long getId() {
		return id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public void insertarProducto(Producto p) {
		this.productos.add(p);
		p.setCliente(this);
	}
	
	public void eliminarProducto(Producto p) {
		this.productos.remove(p);
		p.setCliente(null);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombres == null) ? 0 : nombres.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;

		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombres == null) {
			if (other.nombres != null)
				return false;
		} else if (!nombres.equals(other.nombres))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombres=" + nombres + "]";

	}

}
