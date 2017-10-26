-- ----------------------------------------------------------------------------
-- ----------------------------------------------------------------------------
USE Biblioteca_Personas;
-- ----------------------------------------------------------------------------

-- View de los deportes que practican las personas ----------------------------

CREATE OR REPLACE VIEW View_Personas_Deportes AS
SELECT P.id_persona, D.id_deporte, D.deporte FROM Personas AS P 
    INNER JOIN Personas_Deportes AS PD 
    ON PD.id_persona=P.id_persona 
    INNER JOIN Deportes AS D 
    ON PD.id_deporte=D.id_deporte;

# Ejemplo
# SELECT * FROM View_Personas_Deportes WHERE nombre like '%__BUSQUEDA__%';

-- ----------------------------------------------------------------------------
CREATE OR REPLACE VIEW View_Personas_Info AS
SELECT P.id_persona, P.nombre, P.apellido_paterno, P.apellido_materno, S.id_sexo, 
    S.sexo, E.id_estado, E.estado, M.id_municipio, M.municipio, P.fecha_registro
    FROM Personas AS P 
    INNER JOIN Sexos AS S 
    ON P.id_sexo=S.id_sexo 
    INNER JOIN Municipios AS M 
    ON P.id_municipio=M.id_municipio 
    INNER JOIN Estados AS E 
    ON M.id_estado=E.id_estado;

# Ejemplo
# SELECT * FROM View_Personas_Info WHERE nombre like '%__BUSQUEDA__%';

-- ----------------------------------------------------------------------------
