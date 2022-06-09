package test;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import Clases.VentasClientes;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"classpath:DataSourceTest.xml"}) 
public class PruebaVentasClientes {
//Yañez Rivas Jonatan Alexis
    private static Log logger = LogFactory.getLog("PruebaVentasClientes"); 
    @Autowired
    JdbcTemplate jdbcTemplate; 
    @Test
    public void test() {
    	        	
        logger.info("Inicio de PruebaVentasClientes"); 
        
        logger.info("-----------Registrar venta---------------"); 
        
        VentasClientes registro = new VentasClientes(4,"09-06-2022","Laptop", 1000.500, "Portatil", 2, 4);
        
        registro.insert(jdbcTemplate); // registro nuevo
        
        VentasClientes v = new VentasClientes();
        
        List mostrar = v.report(jdbcTemplate); //mostrar 
        
        for(Object i : mostrar) logger.info(i);
        
        assertEquals(4, mostrar.size());
        
        logger.info("-----------Editar venta---------------"); 
        
        VentasClientes update = new VentasClientes(4,"09-06-2022","Celular", 1000.500, "5G", 1, 4);
        
        update.update(jdbcTemplate); //editar
        
        mostrar = v.report(jdbcTemplate); //mostrar 
        
        for(Object i : mostrar) logger.info(i);
        
        assertEquals(4, mostrar.size());
        
        logger.info("-----------Eliminar venta---------------"); 
        
        v.delete(3, jdbcTemplate); // eliminar
        
        mostrar = v.report(jdbcTemplate); //mostrar 
        
        for(Object i : mostrar) logger.info(i);
        
        assertEquals(3, mostrar.size());
        
        logger.info("----------Buscar venta------------");
        
        mostrar = v.search(2, jdbcTemplate); // buscar
        
        for(Object i : mostrar) logger.info(i);
        
        assertEquals(1, mostrar.size());
        
        logger.info("----------------------");
               
        logger.info("Fin del pruebaVentasClientes");
    }              
}
