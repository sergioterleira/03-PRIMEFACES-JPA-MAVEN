package com.sterleira.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sterleira.model.Cliente;
import com.sterleira.model.Producto;

public class TestClientes {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PERSISTENCE");

	public static void main(String[] args) {
		crearDatos();
		imprimirDatos();
	}

	static void crearDatos() {
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Cliente cliente1 = new Cliente("GALERIAS PRECIADOS");
		Cliente cliente2 = new Cliente("LIDL");
		Cliente cliente3 = new Cliente("ELECTRODOMESTICOS PACO");

		em.persist(cliente1);
		em.persist(cliente2);
		em.persist(cliente3);

		em.persist(new Producto("HP 15-DA0245NS Intel Core i3-7020U/8GB/256GB SSD/15.6\"", cliente1));
		em.persist(new Producto("MSI GF63 Thin 9SC-047XES Intel Corei7-9750H/16GB/512GB SSD/GTX 1650/15.6\"", cliente2));
		em.persist(new Producto("HP 17-DA0245NS Intel Core i5-7020U/8GB/256GB SSD/15.6\"", cliente3));
		em.persist(new Producto("Asus TUF Gaming FX505GT-BQ024 Intel Core i7-9750H/16GB/1TB+256GB SSD/GTX 1650/15.6\"",cliente2));
		em.persist(new Producto("MSI GF63 Thin 9SC-047XES Intel Corei5-9750H/16GB/512GB SSD/GTX 1650/15.6\"", cliente1));

		em.getTransaction().commit();

		em.close();
	}

	static void imprimirDatos() {
		EntityManager em = emf.createEntityManager();

		Cliente cliente1 = em.find(Cliente.class, 1L);
		List<Producto> productos = cliente1.getProductos();
		for (Producto producto : productos) {
			System.out.println("* " + producto.toString());
		}
		System.out.print(cliente1);

		em.close();
	}
}
