package Clases;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class VentasClientes {
	
	private int cod_ventasClientes, total_ventas, cod_clientes;
	private double precio;
	private String fecha, producto, descripcion_producto;
	
	public VentasClientes() {}

	public VentasClientes(int cod_ventasClientes, String fecha, String producto, double precio, String descripcion_producto, int total_ventas,  int cod_clientes) {
		this.cod_ventasClientes = cod_ventasClientes;
		this.total_ventas = total_ventas;
		this.cod_clientes = cod_clientes;
		this.precio = precio;
		this.fecha = fecha;
		this.producto = producto;
		this.descripcion_producto = descripcion_producto;
	}

	public int getCod_ventasClientes() { return cod_ventasClientes; }

	public void setCod_ventasClientes(int cod_ventasClientes) { this.cod_ventasClientes = cod_ventasClientes; }

	public int getTotal_ventas() { return total_ventas; }

	public void setTotal_ventas(int total_ventas) { this.total_ventas = total_ventas; }

	public int getCod_clientes() { return cod_clientes; }

	public void setCod_clientes(int cod_clientes) { this.cod_clientes = cod_clientes; }

	public double getPrecio() {	return precio; }

	public void setPrecio(double precio) { this.precio = precio; }

	public String getFecha() { return fecha; }

	public void setFecha(String fecha) { this.fecha = fecha; }

	public String getProducto() { return producto; }

	public void setProducto(String producto) { this.producto = producto; }

	public String getDescripcion_producto() { return descripcion_producto; }

	public void setDescripcion_producto(String descripcion_producto) { this.descripcion_producto = descripcion_producto; }
	
	public void insert(JdbcTemplate jdbc) {
		String sql ="insert into ventasClientes (cod_ventasClientes, fecha, producto, precio, descripcion_producto, total_ventas, cod_clientes) VALUES(?,?,?,?,?,?,?)";
		jdbc.update(sql, getCod_ventasClientes(), getFecha(), getProducto(), getPrecio(), getDescripcion_producto(), getTotal_ventas(), getCod_clientes());
	}
	
	public void update(JdbcTemplate jdbc) {
		String sql = "update ventasClientes set fecha = ?, producto = ?, precio = ?, descripcion_producto = ?, total_ventas = ?, cod_clientes = ? where cod_ventasClientes = ?";
		jdbc.update(sql, getFecha(), getProducto(), getPrecio(), getDescripcion_producto(), getTotal_ventas(), getCod_clientes(), getCod_ventasClientes());
	}
	
	public void delete(int cod,JdbcTemplate jdbc) {
		String sql = "delete from ventasClientes where cod_ventasClientes = ?";
    	jdbc.update(sql, cod);
	}
	
	public List search(int cod,JdbcTemplate jdbc) {
	    	return jdbc.queryForList("select * from ventasClientes where cod_ventasClientes = ?", cod);
	}
	
	public List report(JdbcTemplate jdbc) {
    	return jdbc.queryForList("select * from ventasClientes");
	}
}
