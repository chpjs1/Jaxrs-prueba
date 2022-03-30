package com.chip.jaxrs.repository;

import javax.enterprise.context.ApplicationScoped;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;

import com.chip.jaxrs.model.Producto;

/**
 * 
 * @author Chip
 * @date lunes 28,03,2022
 *
 */

@ApplicationScoped
public class ProductoRepository {

	@PersistenceContext
    private EntityManager entityManager;

    public List<Producto> listarTodo() {
        return entityManager.createNamedQuery("Products.findAll", Producto.class)
                .getResultList();
    }

    public Producto buscarPorId(Long id) {

    	Producto producto = entityManager.find(Producto.class, id);

        if (producto == null) {
            throw new WebApplicationException("El Producto con el id: " + id + " no existe.", 404);
        }
        return producto;
    }
    
    /*Actualizar un registro del Producto*/
    @Transactional
    public void actualizaProducto(Producto producto) {

    	Producto productToUpdate = buscarPorId(producto.getId());
    	
    	productToUpdate.setSku(producto.getSku());
    	productToUpdate.setNombre(producto.getNombre());
    	productToUpdate.setDescripcion(producto.getDescripcion());
    	productToUpdate.setPrecio(producto.getPrecio());
    	productToUpdate.setCantidadExistente(producto.getCantidadExistente());
    	productToUpdate.setProveedor(producto.getProveedor());
    	
    }
    
    /*Agregar un registro del Producto*/
    @Transactional
    public void agregaProducto(Producto producto) {

        entityManager.persist(producto);

    }
    
    /*Borrar un registro del Producto*/
    @Transactional
    public void borraProducto(Long productoId) {

    	Producto p = buscarPorId(productoId);
        entityManager.remove(p);
    }
}
