DROP DATABASE ioteayudo; -- Los nombres para las bases de datos no funcionan con notación camel case

CREATE DATABASE ioteayudo
   WITH OWNER = postgres
      ENCODING = 'UTF8'
      TABLESPACE = pg_default
      CONNECTION LIMIT = -1;

comment on database IOteayudo
is
'Base de datos para la aplicación IOteayudo.';
