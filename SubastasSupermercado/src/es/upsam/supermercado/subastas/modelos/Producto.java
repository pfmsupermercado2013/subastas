package es.upsam.supermercado.subastas.modelos;

import java.io.Serializable;

public class Producto implements Serializable{

	private static final long serialVersionUID = -7630233025362081017L;

	private int idProducto;
	private int imagenProducto;
	private String nombreProducto;
	
	public int getIdProducto() {
		return idProducto;
	}
	
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	
	public String getNombreProducto() {
		return nombreProducto;
	}
	
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public int getImagenProducto() {
		return imagenProducto;
	}

	public void setImagenProducto(int imagenProducto) {
		this.imagenProducto = imagenProducto;
	}
	
}