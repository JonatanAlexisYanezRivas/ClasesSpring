package Clases;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class Pedidos {
	int cod_pedido, cod_cliente;
	String cod_componenteElectrico;
	
	public Pedidos() {}

	public Pedidos(int cod_pedido, int cod_cliente, String cod_componenteElectrico) {
		super();
		this.cod_pedido = cod_pedido;
		this.cod_cliente = cod_cliente;
		this.cod_componenteElectrico = cod_componenteElectrico;
	}

	public int getCod_pedido() { return cod_pedido; }

	public void setCod_pedido(int cod_pedido) { this.cod_pedido = cod_pedido; }

	public int getCod_cliente() { return cod_cliente; }

	public void setCod_cliente(int cod_cliente) { this.cod_cliente = cod_cliente; }

	public String getCod_componenteElectrico() { return cod_componenteElectrico; }

	public void setCod_componenteElectrico(String cod_componenteElectrico) { this.cod_componenteElectrico = cod_componenteElectrico; }
	
	public void insert(JdbcTemplate jdbc) {
		String sql ="insert into pedido (cod_pedido, cod_cliente, cod_componenteElectrico) VALUES(?,?,?)";
		jdbc.update(sql, getCod_pedido(), getCod_cliente(), getCod_componenteElectrico());
	}
	
	public void update(JdbcTemplate jdbc) {
		String sql = "update pedido set cod_cliente = ?, cod_componenteElectrico = ? where cod_pedido = ?";
		jdbc.update(sql, getCod_cliente(), getCod_componenteElectrico(), getCod_pedido());
	}
	
	public void delete(int cod,JdbcTemplate jdbc) {
		String sql = "delete from pedido where cod_pedido = ?";
    	jdbc.update(sql, cod);
	}
	
	public List search(int cod,JdbcTemplate jdbc) {
	    	return jdbc.queryForList("select * from pedido where cod_pedido = ?", cod);
	}
	
	public List report(JdbcTemplate jdbc) {
    	return jdbc.queryForList("select * from pedido");
	}
	
}
