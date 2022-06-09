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

import Clases.Pedidos;
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:DataSourceTest.xml"})
public class PruebaPedidos {
//Yañez Rivas Jonatan Alexis
    private static Log logger = LogFactory.getLog("PruebaPedidos");
    @Autowired
    JdbcTemplate jdbcTemplate; 
    @Test 
    public void test() {
    	        	
        logger.info("Inicio de PruebaPedidos"); 
        
        logger.info("-----------Registrar Pedido---------------");
        
        Pedidos registro = new Pedidos(4,1,"HP-Black");
        
        registro.insert(jdbcTemplate); // registro nuevo
        
        Pedidos p = new Pedidos();
        
        List mostrar = p.report(jdbcTemplate); //mostrar 
        
        for(Object i : mostrar) logger.info(i);
        
        assertEquals(4, mostrar.size());
        
        logger.info("-----------Editar pedido---------------"); 
        
        Pedidos update = new Pedidos(4,2,"HP-Blue");
        
        update.update(jdbcTemplate); //editar
        
        mostrar = p.report(jdbcTemplate); //mostrar 
        
        for(Object i : mostrar) logger.info(i);
        
        assertEquals(4, mostrar.size());
        
        logger.info("-----------Eliminar pedido---------------");
        
        p.delete(2, jdbcTemplate); //eliminar
        
        mostrar = p.report(jdbcTemplate); //mostrar 
        
        for(Object i : mostrar) logger.info(i);
        
        assertEquals(3, mostrar.size());
        
        logger.info("-----------Buscar pedido---------------");
        
        mostrar = p.search(4, jdbcTemplate); // buscar
        
        for(Object i : mostrar) logger.info(i);
        
        assertEquals(1, mostrar.size());
        
        logger.info("--------------------------"); 
               
        logger.info("Fin del PruebaPedidos"); 

    }
                
}
