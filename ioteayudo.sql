CREATE TABLE usuario (
	id_usuario INTEGER NOT NULL,
	correo_usuario VARCHAR(255) NOT NULL,
	nombre_usuario VARCHAR(255) NOT NULL,
	apellido_paterno_usuario VARCHAR(255) NOT NULL,
	apellido_materno_usuario VARCHAR(255),
	contrasenia_usuario VARCHAR(15) NOT NULL,
	telefono_usuario INTEGER NOT NULL,
	acerca_de_usuario VARCHAR(255) NOT NULL,
	PRIMARY KEY(id_usuario));

CREATE TABLE alumno (
	id_usuario INTEGER NOT NULL,
	fecha_nacimiento_alumno INTEGER,
	CHECK(fecha_nacimiento_alumno >= 15),
	FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario),
	PRIMARY KEY(id_usuario));

CREATE TABLE tutor (
	id_usuario INTEGER NOT NULL,
	nivel_estudios_tutor VARCHAR(255) NOT NULL,
	FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario),
	PRIMARY KEY(id_usuario));

CREATE TABLE materia (
	id_materia INTEGER NOT NULL,
	nombre_materia VARCHAR(255) NOT NULL,
	area_materia INTEGER,
	CHECK(area_materia >= 1 and area_materia <= 4),
	PRIMARY KEY(id_materia));

CREATE TABLE tutor_materia (
	id_usuario INTEGER NOT NULL,
	id_materia INTEGER NOT NULL,
	FOREIGN KEY(id_usuario) REFERENCES tutor(id_usuario),
	FOREIGN KEY(id_materia) REFERENCES materia(id_materia),
	PRIMARY KEY(id_usuario));