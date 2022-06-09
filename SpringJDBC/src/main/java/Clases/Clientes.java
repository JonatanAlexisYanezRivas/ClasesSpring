package Clases;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

public class Clientes {
	
	private int cod_cliente, cedula;
	private String nombre, dirrecion, tel_fijo, tel_cel;

	public Clientes() {	}
	
	public Clientes(int cod_cliente, int cedula, String nombre, String dirrecion, String tel_fijo, String tel_cel) {
		this.cod_cliente = cod_cliente;
		this.cedula = cedula;
		this.nombre = nombre;
		this.dirrecion = dirrecion;
		this.tel_fijo = tel_fijo;
		this.tel_cel = tel_cel;
	}
	
	public int getCod_cliente() { return cod_cliente; }
	
	public void setCod_cliente(int cod_cliente) { this.cod_cliente = cod_cliente; }
	
	public int getCedula() { return cedula; }
	
	public void setCedula(int cedula) { this.cedula = cedula; }
	
	public String getNombre() { return nombre; }
	
	public void setNombre(String nombre) { this.nombre = nombre; }
	
	public String getDirrecion() { return dirrecion; }
	
	public void setDirrecion(String dirrecion) { this.dirrecion = dirrecion; }
	
	public String getTel_fijo() { return tel_fijo; }
	
	public void setTel_fijo(String tel_fijo) { this.tel_fijo = tel_fijo; }
	
	public String getTel_cel() { return tel_cel; }
	
	public void setTel_cel(String tel_cel) { this.tel_cel = tel_cel; }
	
	public void insert(JdbcTemplate jdbc) {
		String sql ="INSERT INTO cliente (id_cod, cedula, nombre, direccion, tel_fijo, tel_cel) VALUES(?,?,?,?,?,?)";
		jdbc.update(sql, getCod_cliente(), getCedula(), getNombre(), getDirrecion(), getTel_fijo(), getTel_cel());
	}
	
	public void update(JdbcTemplate jdbc) {
		String sql = "update cliente set cedula = ?, nombre = ?, direccion = ?, tel_fijo = ?, tel_cel = ? where id_cod = ?";
		jdbc.update(sql, getCedula(), getNombre(), getDirrecion(),getTel_fijo(), getTel_cel(), getCod_cliente());
	}
	
	public void delete(int cod_cliente,JdbcTemplate jdbc) {
		String sql = "delete from cliente where id_cod = ?";
    	jdbc.update(sql, cod_cliente);
	}
	
	public List search(int cod_cliente,JdbcTemplate jdbc) {
	    	return jdbc.queryForList("select * from cliente where id_cod = ?", cod_cliente);
	}
	
	public List report(JdbcTemplate jdbc) {
    	return jdbc.queryForList("select * from cliente");
	}
}
