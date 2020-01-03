CREATE DATABASE VENTAS;
GO
USE VENTAS

CREATE TABLE CLIENTES(
    id int identity(1,1) primary key,
    nombres varchar(25) not null
)

INSERT INTO CLIENTES (nombres) VALUES ('EL CORTE INGLES')
INSERT INTO CLIENTES (nombres) VALUES ('MEDIAMARK')
INSERT INTO CLIENTES (nombres) VALUES ('PCCOMPONENTES')

CREATE TABLE PRODUCTOS(
    id_cliente int not null,
    id int identity(1,1) not null,
    nombre varchar(200) not null,
    CONSTRAINT FK_CLIENTE FOREIGN KEY(id_cliente) references CLIENTES(id),
    CONSTRAINT PK_PRODUCTOS PRIMARY KEY(id_cliente,id) 
)
CREATE UNIQUE INDEX indx_name ON PRODUCTOS([nombre]);
CREATE FULLTEXT INDEX ON PRODUCTOS (nombre) KEY INDEX unique_key_index   
   WITH SEARCH PROPERTY LIST=spl_1;   

INSERT INTO PRODUCTOS(id_cliente,[nombre]) VALUES (1,'Monitor DELL UltraSharp 24');
INSERT INTO PRODUCTOS(id_cliente,[nombre]) VALUES (2,'Pantalla UltraSharp Dell 24');
INSERT INTO PRODUCTOS(id_cliente,[nombre]) VALUES (3,'Xiaomi Mi Airdots Auriculares Inalámbricos Negro');
INSERT INTO PRODUCTOS(id_cliente,[nombre]) VALUES (2,'Xiaomi Mi Airdots Auriculares Inalámbricos Blanco');
INSERT INTO PRODUCTOS(id_cliente,[nombre]) VALUES (1,'Xiaomi Mi Airdots Auriculares Inalámbricos Gris');
INSERT INTO PRODUCTOS(id_cliente,[nombre]) VALUES (1,'Xiaomi Mi Airdots Auriculares Inalámbricos Rosa');

INSERT INTO PRODUCTOS(id_cliente,[nombre]) VALUES (1,'Xiaomi Mi Smart Band 4 Negra');
INSERT INTO PRODUCTOS(id_cliente,[nombre]) VALUES (2,'Xiaomi Mi Smart Band 4 Blanca');
INSERT INTO PRODUCTOS(id_cliente,[nombre]) VALUES (3,'Xiaomi Mi Smart Band 4 Gris');
INSERT INTO PRODUCTOS(id_cliente,[nombre]) VALUES (1,'Xiaomi Mi Smart Band 4 Rosa');


