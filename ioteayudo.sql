CREATE TABLE usuario (
	id_usuario INTEGER NOT NULL,
	nombre_usuario VARCHAR(255) NOT NULL,
	apellido_paterno_usuario VARCHAR(255) NOT NULL,
	apellido_materno_usuario VARCHAR(255),
	contrasenia_usuario VARCHAR(15) NOT NULL,
	telefono_usuario INTEGER NOT NULL,
	acerca_de_usuario VARCHAR(255) NOT NULL,
	PRIMARY KEY(id_usuario));

CREATE TABLE alumno (
	id_usuario INTEGER NOT NULL,
	edad_alumno INTEGER,
	CHECK(edad_alumno >= 15),
	FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario),
	PRIMARY KEY(id_usuario));

CREATE TABLE tutor (
	id_usuario INTEGER NOT NULL,
	nivel_estudios_tutor VARCHAR(255) NOT NULL,
	FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario),
	PRIMARY KEY(id_usuario));

CREATE TABLE tutor_curso (
	id_usuario INTEGER NOT NULL,
	nombre_curso VARCHAR(255) NOT NULL,
	FOREIGN KEY(id_usuario) REFERENCES tutor(id_usuario),
	PRIMARY KEY(id_usuario));

CREATE TABLE tutor_area (
	id_usuario INTEGER NOT NULL,
	nombre_area VARCHAR(255) NOT NULL,
	CHECK(nombre_area IN ('A1', 'A2', 'A3', 'A4')),
	FOREIGN KEY (id_usuario) REFERENCES tutor(id_usuario),
	PRIMARY KEY(id_usuario));