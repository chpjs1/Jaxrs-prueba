package com.chip.jaxrs.model.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import com.chip.jaxrs.model.Producto;
import com.chip.jaxrs.repository.ProductoRepository;

import java.util.List;

/**
 * 
 * @author Chip
 * @date lunes 28,03,2022
 *
 */


@Path("productos")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class ProductoEndPoint {
	@Inject ProductoRepository productoRepository;

    @GET
    public List<Producto> listar() {
        return productoRepository.listarTodo();
    }

    @POST
    public Response agregar(Producto producto) {
    	productoRepository.agregaProducto(producto);
        return Response.status(201).build();
    }

    @PUT
    public Response actualizar(Producto producto) {
    	productoRepository.actualizaProducto(producto);
        return Response.status(204).build();
    }
    @DELETE
    public Response borrar(@QueryParam("id") Long productoId) {
    	productoRepository.borraProducto(productoId);
        return Response.status(204).build();
    }
}
