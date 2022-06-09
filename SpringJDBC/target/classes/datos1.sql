insert into cliente (id_cod, cedula, nombre, direccion, tel_fijo, tel_cel) values (1, 123, 'Jonatan', 'Valle', '56-11-98-27-35', '12-34-56-78-90');
insert into cliente (id_cod, cedula, nombre, direccion, tel_fijo, tel_cel) values (2, 223, 'Alexis', 'Chalco', '56-01-78-57-31', '11-24-36-48-50');
insert into cliente (id_cod, cedula, nombre, direccion, tel_fijo, tel_cel) values (3, 323, 'Maria', 'La paz', '56-21-28-27-25', '32-34-46-38-40');

insert into ventasClientes (cod_ventasClientes, fecha, producto, precio, descripcion_producto, total_ventas, cod_clientes) values (1, '08-06-2022', 'Pc gamer', 15000.0, 'Veloz', 2, 1);
insert into ventasClientes (cod_ventasClientes, fecha, producto, precio, descripcion_producto, total_ventas, cod_clientes) values (2, '08-06-2022', 'Tablet', 5000.0, 'Pantalla HD', 1, 2);
insert into ventasClientes (cod_ventasClientes, fecha, producto, precio, descripcion_producto, total_ventas, cod_clientes) values (3, '08-06-2022', 'Teclado', 800.0, 'RGB', 5, 3);

insert into pedido (cod_pedido, cod_cliente, cod_componenteElectrico) values (1, 1,'PC01-rgb');
insert into pedido (cod_pedido, cod_cliente, cod_componenteElectrico) values (2, 2,'TB-azul');
insert into pedido (cod_pedido, cod_cliente, cod_componenteElectrico) values (3, 3,'T-Mecanico');