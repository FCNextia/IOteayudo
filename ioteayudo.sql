-- TODO: Ajustar el readme para indicar como cargar el archivo (MAPA 2016-05-06)
begin;
set client_encoding = 'utf-8';

--Esta extensión es muy importante para el caso de uso Buscar Tutor
--Si por x o z razón les manda un error favor de buscar como
--instalarla en su computadora.
CREATE EXTENSION IF NOT EXISTS pg_trgm;

CREATE TABLE usuario (
	id_usuario serial primary key, -- Cambio el tipo por uno serial, el tipo se encarga de generar la secuencia de forma automática
	correo_usuario text NOT NULL CHECK(correo_usuario SIMILAR TO '[0-9A-Za-z -_.áéíóúñü]+@%.%'),
	nombre_usuario text NOT NULL CHECK(nombre_usuario SIMILAR TO '[A-Za-z]+'),
	apellido_paterno_usuario text NOT NULL CHECK(apellido_paterno_usuario SIMILAR TO '[A-Za-záéíóúñü]+'),
	apellido_materno_usuario text NOT NULL CHECK(apellido_materno_usuario SIMILAR TO '[A-Za-záéíóúñü]+'),
	contrasenia_usuario VARCHAR(15) NOT NULL,
	telefono_usuario BIGINT NOT NULL CHECK(telefono_usuario <= 9999999999),
	acerca_de_usuario VARCHAR(255) NOT NULL
);

comment on table usuario
is
'El usuario con nombre NOMBRE_USUARIO, apellido paterno
APELLIDO_PATERNO_USUARIO, apellido materno APELLIDO MATERNO tiene una contraseña
CONTRASENIA_USUARIO y telefono TELEFONO_USUARIO teniendo como información
adicional ACERCA_DE_USUARIO.';

CREATE TABLE alumno (
	id_usuario INTEGER primary key references usuario(id_usuario),
	fecha_nacimiento_alumno DATE CHECK ( date_part('year',age(fecha_nacimiento_alumno)) >= 15 )
);

comment on table alumno
is
'El usuario ID_USUARIO es un alumno que con fecha de nacimiento
FECHA_NACIMIENTO_ALUMNO.';

CREATE TABLE estudios (
    nivel_estudios_tutor text PRIMARY KEY
);

comment on table estudios
is
'Es el nivel de estudios NIVEL_ESTUDIOS_TUTOR para un tutor.';

--Con respecto al problema de los tutores, bastaba con quitarle
--la nularidad a la columna nivel_estudios_tutor
CREATE TABLE tutor (
	id_usuario int primary key references usuario(id_usuario),
	nivel_estudios_tutor text references estudios(nivel_estudios_tutor)
);

comment on table tutor
is
'El usuario ID_USUARIO es un tutor con nivel de estudios NIVEL_ESTUDIOS_TUTOR.';

CREATE TABLE materia (
	id_materia serial primary key,
	nombre_materia text NOT NULL,
	area_materia int,
	CHECK(area_materia >= 1 and area_materia <= 4)
);

comment on table materia
is
'La materia ID_MATERIA con nombre NOMBRE_MATERIA se encuentra en el área
AREA_MATERIA';

CREATE TABLE tutor_materia (
	id_usuario int not null references tutor(id_usuario),
	id_materia int not null references materia(id_materia)
);

comment on table tutor_materia
is
'El tutor ID_USUARIO imparte la materia ID_MATERIA';


INSERT INTO estudios (nivel_estudios_tutor) VALUES
('Bachillerato'),
('Licenciatura'),
('Maestría'),
('Posgrado');

--Función que regresa todos los tutores dado un nombre de una materia.
create or replace function buscatutor(v_nombre_materia text)
returns setof usuario as $$
  select usuario.*
  from usuario
    inner join tutor on (usuario.id_usuario = tutor.id_usuario)
    inner join tutor_materia on (usuario.id_usuario = tutor_materia.id_usuario)
    inner join materia on (tutor_materia.id_materia = materia.id_materia)
  where nombre_materia = v_nombre_materia;
$$ language sql stable;

comment on function buscatutor(v_nombre_materia text)
is
'Busca a todos los tutores que se encuentran impartiendo la materia
V_NOMBRE_MATERIA.';

commit;
