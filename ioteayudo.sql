CREATE DATABASE IOteayudo
   WITH OWNER = postgres
      ENCODING = 'UTF8'
      TABLESPACE = pg_default
      CONNECTION LIMIT = -1;

CREATE TABLE usuario (
	id_usuario INTEGER NOT NULL,
	correo_usuario VARCHAR(255) NOT NULL CHECK(correo_usuario SIMILAR TO '[0-9A-Za-z -_.áéíóúñü]+@%.%'),
	nombre_usuario VARCHAR(255) NOT NULL CHECK(nombre_usuario SIMILAR TO '[A-Za-z]+'),
	apellido_paterno_usuario VARCHAR(255) NOT NULL CHECK(apellido_paterno_usuario SIMILAR TO '[A-Za-záéíóúñü]+'),
	apellido_materno_usuario VARCHAR(255) NOT NULL CHECK(apellido_materno_usuario SIMILAR TO '[A-Za-záéíóúñü]+'),
	contrasenia_usuario VARCHAR(15) NOT NULL,
	telefono_usuario VARCHAR(10) NOT NULL,
	acerca_de_usuario VARCHAR(255) NOT NULL,
	PRIMARY KEY(id_usuario));

CREATE TABLE alumno (
	id_usuario INTEGER NOT NULL,
	fecha_nacimiento_alumno DATE CHECK (date_part('year',age(fecha_nacimiento_alumno)) >= 15),
	FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario),
	PRIMARY KEY(id_usuario));

CREATE TABLE tutor (
	id_usuario INTEGER NOT NULL PRIMARY KEY,
	nivel_estudios_tutor VARCHAR(255) NOT NULL,
	FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario));

CREATE TABLE materia (
	id_materia INTEGER NOT NULL PRIMARY KEY,
	nombre_materia VARCHAR(255) NOT NULL,
	area_materia INTEGER,
	CHECK(area_materia >= 1 and area_materia <= 4));

CREATE TABLE tutor_materia (
	id_usuario INTEGER NOT NULL,
	id_materia INTEGER NOT NULL,
	FOREIGN KEY(id_usuario) REFERENCES tutor(id_usuario),
	FOREIGN KEY(id_materia) REFERENCES materia(id_materia));