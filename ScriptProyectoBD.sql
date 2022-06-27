CREATE DATABASE proyecto

use proyecto


Alter table Persona ADD imgfoto varchar(100)

CREATE TABLE Departamentos(
	id_departamento int primary key,
	departamento varchar(30)
);

INSERT INTO Departamentos
VALUES (1, 'Ancash')

CREATE TABLE Provincias(
	id_provincia int primary key,
	provincia varchar(30),
	id_departamento int references Departamentos(id_departamento)
);

INSERT INTO Provincias
VALUES	(1, 'Aija', 1),
		(2, 'Antonio Raimondi', 1),
		(3, 'Asunción', 1),
		(4, 'Bolognesi', 1),
		(5, 'Carhuaz', 1),
		(6, 'Carlos Fermín Fitzcarrald', 1),
		(7, 'Casma', 1),
		(8, 'Corongo', 1),
		(9, 'Huaraz', 1),
		(10, 'Huari', 1),
		(11, 'Huarmey', 1),
		(12, 'Huaylas', 1),
		(13, 'Mariscal Luzuriaga', 1),
		(14, 'Ocros', 1),
		(15, 'Pallasca', 1),
		(16, 'Pomabamba', 1),
		(17, 'Recuay', 1),
		(18, 'Santa', 1),
		(19, 'Sihuas', 1),
		(20, 'Yungay', 1)

CREATE TABLE Distritos(
	id_distrito int primary key,
	distrito varchar(30),
	id_provincia int references Provincias(id_provincia)
);

INSERT INTO Distritos
VALUES	(1, 'Cáceres del Perú', 18),
		(2, 'Chimbote', 18),
		(3, 'Coishco', 18),
		(4, 'Macate', 18),
		(5, 'Moro', 18),
		(6, 'Nepeña', 18),
		(7, 'Nuevo Chimbote', 18),
		(8, 'Samanco', 18),
		(9, 'Santa', 18)

CREATE TABLE Pregunta(
	id_pregunta int primary key,
	pregunta varchar(200),
	id_icon int references Iconos(id_icon)
);


CREATE TABLE Respuesta(
	id_respuesta int primary key,
	respuesta varchar(15) default 'Nunca'
);

CREATE TABLE SU(
	id_user int identity (1, 1) not null primary key,
	user_name varchar(30),
	user_pass varchar(30)
);

CREATE TABLE Reporte(
	id_reporte int primary key,
	id_persona int references Persona(id_persona),
	porcentaje int,
	tieneDiabetes varchar(10),
	fecha date
);

CREATE TABLE PreguntaRespuesta(
	id_persona int references Persona(id_persona),
	id_pregunta int references Pregunta(id_pregunta),
	id_respuesta int references Respuesta(id_respuesta)
);

CREATE TABLE Iconos(
	id_icon int primary key,
	link varchar(200)
);


INSERT INTO Pregunta
VALUES	(1, '¿Siente la necesidad exagerada de tomar agua?', 1),
		(2, '¿Siente la sensacion incontenible de hambre a pesar de haber comido?', 2),
		(3, '¿Siente que la emision de el volumen de orina es superior al esperado?', 3),
		(4, '¿Siente que pierde peso rápido a pesar de su hambre constante?', 4),
		(5, '¿Con que frecuencia se siente con cansancio?', 5),
		(6, '¿Con que frecuencia a sentidos entumecimientos (pies - manos)?', 6),
		(7, '¿Con que frecuencia a sentido que su vista esta borrosa?', 7),
		(8, '¿Con que frecuencia tiene llagas de curacion lenta?', 8)

Insert into Iconos
Values	(1, 'https://cdn-icons-png.flaticon.com/128/2554/2554492.png'),
		(2, 'https://cdn-icons-png.flaticon.com/128/4807/4807849.png'),
		(3, 'https://cdn-icons-png.flaticon.com/128/3030/3030914.png'),
		(4, 'https://cdn-icons-png.flaticon.com/128/3030/3030914.png'),
		(5, 'https://cdn-icons-png.flaticon.com/128/4805/4805887.png'),
		(6, 'https://cdn-icons-png.flaticon.com/128/4354/4354623.png'),
		(7, 'https://image.flaticon.com/icons/png/128/18/18537.png'),
		(8, 'https://surgicorperu.com/wp-content/uploads/2021/05/herida.png')


INSERT INTO Respuesta
VALUES	(1, 'Nunca'),
		(2, 'Casi nunca'),
		(3, 'En ocasiones'),
		(4, 'Con frecuencia'),
		(5, 'Casi siempre'),
		(6, 'Siempre')


-----------------------------------------------------------------------------------------
CREATe PROCEDURE RespuestaEspecifica(
	@id_persona int
)AS
BEGIN
	select per.nombres, p.pregunta, r.respuesta
	from persona per	INNER JOIN PreguntaRespuesta pr ON per.id_persona = pr.id_persona
						INNER JOIN Pregunta p ON p.id_pregunta = pr.id_pregunta
						INNER JOIN Respuesta r ON r.id_respuesta = pr.id_respuesta
	where per.id_persona = @id_persona
END;
-------------------------------------------------------------------------------------------
CREATE PROCEDURE ReporteGeneral
AS
BEGIN
	select p.nombres, p.apellidos, DATEDIFF(YEAR,fecha_nacimiento,GETDATE()) as edad, r.porcentaje, r.tieneDiabetes, r.fecha 
	from Reporte r	INNER JOIN Persona p ON r.id_persona = p.id_persona
END;

-------------------------------------------------------
CREATE FUNCTION dbo.porcentaje(
	@id_persona int
)returns int
AS
BEGIN
	DECLARE @cantidad int;

	select @cantidad = SUM(id_respuesta - 1)  * 100 / 40 
	from PreguntaRespuesta 
	where id_persona = @id_persona

	return @cantidad
END;

--Ingresar Persona
------------------------------------------------------------------------
CREATE PROCEDURE RegistrarPersona(
	@id_persona int,
	@DNI varchar(8),
	@nombres varchar(30),
	@apellidos varchar(30),
	@fecha_nacimiento date,
	@telefono varchar(15),
	@correo varchar(30),
	@id_distrito int,
	@imgfoto varchar(100)
)AS 
BEGIN

	INSERT INTO Persona (id_persona, DNI, nombres, apellidos, fecha_nacimiento, telefono, correo, id_distrito, imgfoto)
	VALUES	(@id_persona, @DNI, @nombres, @apellidos, @fecha_nacimiento, @telefono, @correo, @id_distrito, @imgfoto)

END;

--Registrar Respuestas
---------------------------------------------------------------------------
CREATE PROCEDURE RegistrarRespuestas(
	@id_persona int,
	@r1 int,
	@r2 int,
	@r3 int,
	@r4 int,
	@r5 int,
	@r6 int,
	@r7 int,
	@r8 int
)AS 
BEGIN
	INSERT INTO PreguntaRespuesta(id_persona, id_pregunta, id_respuesta)
	VALUES	(@id_persona, 1, @r1),
			(@id_persona, 2, @r2),
			(@id_persona, 3, @r3),
			(@id_persona, 4, @r4),
			(@id_persona, 5, @r5),
			(@id_persona, 6, @r6),
			(@id_persona, 7, @r7),
			(@id_persona, 8, @r8)
END;

--Registrar Reporte
-----------------------------------------------
CREATE PROCEDURE RegistrarReporte(
	@id_persona int
)AS 
BEGIN
	DECLARE @porcentaje int 
	select @porcentaje = dbo.porcentaje(@id_persona)
	
	IF @porcentaje > 50
		INSERT INTO Reporte (id_reporte, id_persona, porcentaje, tieneDiabetes, fecha)
		VALUES	(@id_persona, @id_persona, @porcentaje, 'Si', GETDATE())
	ELSE
		INSERT INTO Reporte (id_reporte, id_persona, porcentaje, tieneDiabetes, fecha)
		VALUES	(@id_persona, @id_persona, @porcentaje, 'No', GETDATE())
END;

--Actualizar Respuesta y Reporte
------------------------------------------------
CREATE PROCEDURE Actualizar(
	@id_persona int,
	@id_pregunta int,
	@id_respuesta int
)AS
BEGIN
	
	UPDATE PreguntaRespuesta
	SET id_respuesta = @id_respuesta
	WHERE id_persona = @id_persona and id_pregunta = @id_pregunta

	DECLARE @porcentaje int
	SELECT @porcentaje = dbo.porcentaje(@id_persona)
	
	UPDATE Reporte
	SET porcentaje = @porcentaje
	WHERE id_persona = @id_persona

	IF @porcentaje > 50
		UPDATE Reporte
		SET tieneDiabetes = 'Si'
		WHERE id_persona = @id_persona
	ELSE
		UPDATE Reporte
		SET tieneDiabetes = 'No'
		WHERE id_persona = @id_persona
END;

------------------------------------------------------------------------------
CREATE PROCEDURE Filtro(
	@tieneDiabetes varchar(10),
	@distrito varchar(30),
	@edad int
)AS 
BEGIN
	IF @edad = -1
		select p.DNI, p.apellidos, p.nombres, DATEDIFF(YEAR,p.fecha_nacimiento,GETDATE()) as edad,d.distrito, r.porcentaje, r.tieneDiabetes
		from reporte r inner join Persona p on r.id_persona = p.id_persona
					inner join Distritos d on p.id_distrito = d.id_distrito
		where d.distrito LIKE (CONCAT(@distrito,'%'))
		and r.tieneDiabetes Like (CONCAT(@tieneDiabetes,'%'))
	
	ELSE IF @edad >= 0 and @edad < 18
		select p.DNI, p.apellidos, p.nombres, DATEDIFF(YEAR,p.fecha_nacimiento,GETDATE()) as edad,d.distrito, r.porcentaje, r.tieneDiabetes
		from reporte r inner join Persona p on r.id_persona = p.id_persona
					inner join Distritos d on p.id_distrito = d.id_distrito
		where d.distrito LIKE (CONCAT(@distrito,'%'))
		and r.tieneDiabetes Like (CONCAT(@tieneDiabetes,'%'))
		and DATEDIFF(YEAR,p.fecha_nacimiento,GETDATE()) between 0 and 17

	ELSE IF @edad >= 18
		select p.DNI, p.apellidos, p.nombres, DATEDIFF(YEAR,p.fecha_nacimiento,GETDATE()) as edad,d.distrito, r.porcentaje, r.tieneDiabetes
		from reporte r inner join Persona p on r.id_persona = p.id_persona
					inner join Distritos d on p.id_distrito = d.id_distrito
		where d.distrito LIKE (CONCAT(@distrito,'%'))
		and r.tieneDiabetes Like (CONCAT(@tieneDiabetes,'%'))
		and DATEDIFF(YEAR,p.fecha_nacimiento,GETDATE()) between 18 and 100
END;


select * from PreguntaRespuesta