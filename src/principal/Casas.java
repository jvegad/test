/*
 * Cada una de estas familias vive en una casa, de la que se conoce la dirección (calle,
numero, código postal, ciudad y país), el periodo de disponibilidad de la casa
(fecha_desde, fecha_hasta), la cantidad de días mínimo de estancia y la cantidad
máxima de días, el precio de la habitación por día y el tipo de vivienda.
 */
package estancias.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @author jvegad
 */
public class Casas {
    //ATRIBUTOS
    private Integer idCasa;
    private String calle;
    private Integer numero;
    private String codigoPostal;
    private String ciudad;
    private String pais;
    private Date fechaDesde;
    private Date fechaHasta;
    private Integer tiempoMinimo;
    private Integer tiempoMaximo;
    private double precioHabitacion;
    private String tipoVivienda;
    //CONSTRUCTOR
    public Casas(String calle, Integer numero, String codigoPostal, String ciudad, 
            String pais, Date fechaDesde, Date fechaHasta, Integer tiempoMinimo, 
            Integer tiempoMaximo, double precioHabitacion, String tipoVivienda) {
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.pais = pais;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.tiempoMinimo = tiempoMinimo;
        this.tiempoMaximo = tiempoMaximo;
        this.precioHabitacion = precioHabitacion;
        this.tipoVivienda = tipoVivienda;
    }
    public Casas() {
        this.calle = "";
        this.numero = 0;
        this.codigoPostal = "";
        this.ciudad = "";
        this.pais = "";
        this.fechaDesde = new Date();
        this.fechaHasta = new Date();
        this.tiempoMinimo = 0;
        this.tiempoMaximo = 0;
        this.precioHabitacion = 0;
        this.tipoVivienda = "";
    }
    //GETTER & SETTER
    public Integer getIdCasa() {
        return idCasa;
    }    
    public void setIdCasa(Integer idCasa) {
        this.idCasa = idCasa;
    }
    public String getCalle() {
        return calle;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }
    public Integer getNumero() {
        return numero;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    public String getCodigoPostal() {
        return codigoPostal;
    }
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    /**
     * METODO GET STRING FECHA:
     * Obtiene el string de la fecha del objeto date
     * @param fecha objeto del tipo date
     * @return un string del formato dd-mm-yyyy
     */
    public String getStringFecha(Date fecha) {
        String newfecha;
        newfecha = new SimpleDateFormat("dd-MM-yyyy").format(fecha);
        return newfecha;
    }
    public Date getFechaDesde() {
        return fechaDesde;
    }
    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }
    public Date getFechaHasta() {
        return fechaHasta;
    }
    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }
    public Integer getTiempoMinimo() {
        return tiempoMinimo;
    }
    public void setTiempoMinimo(Integer tiempoMinimo) {
        this.tiempoMinimo = tiempoMinimo;
    }
    public Integer getTiempoMaximo() {
        return tiempoMaximo;
    }
    public void setTiempoMaximo(Integer tiempoMaximo) {
        this.tiempoMaximo = tiempoMaximo;
    }
    public double getPrecioHabitacion() {
        return precioHabitacion;
    }
    public void setPrecioHabitacion(double precioHabitacion) {
        this.precioHabitacion = precioHabitacion;
    }
    public String getTipoVivienda() {
        return tipoVivienda;
    }
    public void setTipoVivienda(String tipoVivienda) {
        this.tipoVivienda = tipoVivienda;
    }
  
}
