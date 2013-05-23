package es.upsam.supermercado.subastas.modelos;

import java.io.Serializable;
import java.util.Date;

public class Subasta implements Serializable {

	private static final long serialVersionUID = -1753009690882233354L;

	private int idSubasta;
	private Date fechaInicio;
	private Date fechaFin;
	private double pujaInicial;
	private int estado;
	private int unidades;
	private int numeroPujas;
	private Producto producto;
	
	public int getIdSubasta() {
		return idSubasta;
	}
	
	public void setIdSubasta(int idSubasta) {
		this.idSubasta = idSubasta;
	}
	
	public Date getFechaInicio() {
		return fechaInicio;
	}
	
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public Date getFechaFin() {
		return fechaFin;
	}
	
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public double getPujaInicial() {
		return pujaInicial;
	}
	
	public void setPujaInicial(double pujaInicial) {
		this.pujaInicial = pujaInicial;
	}
	
	public int getEstado() {
		return estado;
	}
	
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	public Producto getProducto() {
		return producto;
	}
	
	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public int getNumeroPujas() {
		return numeroPujas;
	}

	public void setNumeroPujas(int numeroPujas) {
		this.numeroPujas = numeroPujas;
	}

}