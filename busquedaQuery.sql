SELECT * FROM usuario as a INNER JOIN 
              tutor as b ON (a.id_usuario = b.id_usuario) INNER JOIN 
              tutor_materia as c ON (a.id_usuario = c.id_usuario) INNER JOIN
              materia as d ON (c.id_materia = d.id_materia) 
LIKE nombre_materia = ? ;
