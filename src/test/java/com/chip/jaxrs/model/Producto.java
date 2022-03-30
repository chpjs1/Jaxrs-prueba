package com.chip.jaxrs.model;

import javax.persistence.*;

/**
 * 
 * @author Chip
 * @date lunes 28,03,2022
 *
 */
@Entity
@NamedQuery(name = "Products.findAll",
        query = "SELECT p FROM Producto p ORDER BY p.id")
public class Producto {

	@Id
    @SequenceGenerator(
            name = "productoSecuencial",
            sequenceName = "ProductoId_seq",
            allocationSize = 1,
            initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productoSecuencial")
    private Long id;
	
	
    @Column(length = 10)
    private String sku;
    
    @Column(length = 75)
    private String nombre;

    @Column(length = 150)
    private String descripcion;
    
    @Column(length = 15)
    private Float precio;
    
    @Column(length = 8)
    private Float cantidadExistente;
        
    @Column(length = 150)
    private String proveedor;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public Float getCantidadExistente() {
		return cantidadExistente;
	}

	public void setCantidadExistente(Float cantidadExistente) {
		this.cantidadExistente = cantidadExistente;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
    
    
}
