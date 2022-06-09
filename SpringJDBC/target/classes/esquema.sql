drop table if exists persona;

create table persona (  
    id_persona identity primary key,  
    nombre varchar(50) not null,  
    ape_paterno varchar(50) not null,  
    ape_materno varchar(50),  
    email varchar(50) not null unique
); 

drop table if exists cliente;

create table cliente(
	id_cod int not null primary key,
	cedula int,
	nombre varchar(50),
	direccion varchar(50),
	tel_fijo varchar(20),
	tel_cel varchar(20)
);

drop table if exists ventasClientes;

create table ventasClientes(
	cod_ventasClientes int not null primary key,
	fecha varchar(50),
	producto varchar(50),
	precio double, 
	descripcion_producto varchar(100),
	total_ventas int,
	cod_clientes int
);

drop table if exists pedido;

create table pedido(
	cod_pedido int not null primary key,
	cod_cliente int,
	cod_componenteElectrico varchar(50)	
);
