package test; //paquete en el que se encuentra el archivo
//importaciones
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import Clases.Clientes;

@RunWith(SpringJUnit4ClassRunner.class) //Funcionalidad de Spring testContext Framework para pruebas con JUnit
@ContextConfiguration(locations = {"classpath:DataSourceTest.xml"}) //Obtiene la configuracion del contexto del xml
public class PruebaJDBC {// nombre de la clase
//Yañez Rivas Jonatan Alexis
    private static Log logger = LogFactory.getLog("PruebaJDBC"); //Ejecutamos nuestro archivo "PruebaJDBC"
    @Autowired
    JdbcTemplate jdbcTemplate; 
    @Test
    public void test() {
    	        	
        logger.info("Inicio de PruebaCliente"); // Nos sirve para imprimir en consola
        
        logger.info("-----------Registrar cliente---------------"); 
        
        Clientes c = new Clientes();
        
        Clientes clienteInsert = new Clientes(4,123,"Jonatan","Valle","55-61-76-88-14","55-20-77-85-15");
        
        clienteInsert.insert(jdbcTemplate); //Registrar informacion
       
        List mostrar = c.report(jdbcTemplate); //Reporte de registros
        
        for(Object i : mostrar) logger.info(i); 
        
        assertEquals(4, mostrar.size());
        
        logger.info("------------Editar Cliente--------------"); 
        
        Clientes clienteUpdate = new Clientes(4,333,"Rivas","Ixtapaluca","55-61-76-88-14","55-20-77-85-15");
        
        clienteUpdate.update(jdbcTemplate); //Editar registro
        
        List mostrarUpdate = c.report(jdbcTemplate);
        
        for(Object i : mostrarUpdate) logger.info(i);
        
        assertEquals(4, mostrarUpdate.size());
        
        logger.info("------------Buscar cliente------------");
              
        List buscarCod = c.search(1, jdbcTemplate); //Buscar registro
        
        for(Object i : buscarCod) logger.info(i);
        
        assertEquals(1, buscarCod.size());
        
        logger.info("----------Eliminar cliente-----------");
        
        c.delete(4, jdbcTemplate);
        
        List mostrarDelete = c.report(jdbcTemplate); // Elimina registro
        
        for(Object i : mostrarDelete) logger.info(i);
        
        assertEquals(3, mostrarDelete.size());
        
        logger.info("---------------------");
        
        logger.info("Fin del PruebaCliente");

    }              
}
