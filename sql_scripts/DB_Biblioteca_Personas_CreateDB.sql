-- ----------------------------------------------------------------------------
-- ----------------------------------------------------------------------------
DROP DATABASE IF EXISTS Biblioteca_Personas;
CREATE DATABASE Biblioteca_Personas;
USE Biblioteca_Personas;
-- ----------------------------------------------------------------------------

-- Tabla con los estados de la republica mexicana ---------------------------01
DROP TABLE IF EXISTS Estados;

CREATE TABLE Estados (
    id_estado int NOT NULL, 
    estado varchar(100) NOT NULL, 
    PRIMARY KEY (id_estado))
ENGINE=InnoDB  DEFAULT CHARSET=UTF8;
-- ----------------------------------------------------------------------------

-- Tabla con los municipios de cada estado ----------------------------------02
DROP TABLE IF EXISTS Municipios;

CREATE TABLE Municipios (
    id_municipio int NOT NULL,
    id_estado int NOT NULL, 
    municipio varchar(100) NOT NULL, 
    PRIMARY KEY (id_municipio),
    CONSTRAINT FK_02_01 FOREIGN KEY (id_estado) REFERENCES Estados(id_estado)
    ON DELETE CASCADE ON UPDATE CASCADE)
ENGINE=InnoDB  DEFAULT CHARSET=UTF8;
-- ----------------------------------------------------------------------------

-- Tabla con los sexos disponibles ------------------------------------------03
DROP TABLE IF EXISTS Sexos;

CREATE TABLE Sexos (
    id_sexo int NOT NULL,
    sexo varchar(20) NOT NULL,	
    PRIMARY KEY (id_sexo))
ENGINE=InnoDB  DEFAULT CHARSET=UTF8;
-- ----------------------------------------------------------------------------

-- Tabla con los deportes disponibles ---------------------------------------04
DROP TABLE IF EXISTS Deportes;

CREATE TABLE Deportes (
    id_deporte int NOT NULL,
    deporte varchar(30) NOT NULL,	
    PRIMARY KEY (id_deporte))
ENGINE=InnoDB  DEFAULT CHARSET=UTF8;
-- ----------------------------------------------------------------------------

-- Tabla con las personas registradas ---------------------------------------05
DROP TABLE IF EXISTS Personas;

CREATE TABLE Personas (
    id_persona int NOT NULL AUTO_INCREMENT,
    nombre varchar(50) NOT NULL,
    apellido_paterno varchar(50),
    apellido_materno varchar(50),
    id_sexo int NOT NULL,
    id_municipio int NOT NULL, 
    fecha_registro date,
    PRIMARY KEY (id_persona),
    CONSTRAINT FK_05_01 FOREIGN KEY (id_sexo) REFERENCES Sexos(id_sexo)
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_05_03 FOREIGN KEY (id_municipio) REFERENCES Municipios(id_municipio)
        ON DELETE CASCADE ON UPDATE CASCADE)
ENGINE=InnoDB  DEFAULT CHARSET=UTF8;
ALTER TABLE Personas ADD UNIQUE (nombre, apellido_paterno, apellido_materno);
-- ----------------------------------------------------------------------------

-- Tabla de relacion personas-deportes --------------------------------------06
DROP TABLE IF EXISTS Personas_Deportes;

CREATE TABLE Personas_Deportes (
    id int NOT NULL AUTO_INCREMENT,
    id_persona int NOT NULL,
    id_deporte int NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_06_01 FOREIGN KEY (id_persona) REFERENCES Personas(id_persona)
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_06_02 FOREIGN KEY (id_deporte) REFERENCES Deportes(id_deporte)
        ON DELETE CASCADE ON UPDATE CASCADE)
ENGINE=InnoDB  DEFAULT CHARSET=UTF8;
ALTER TABLE Personas_Deportes ADD UNIQUE (id_persona,id_deporte);
-- ----------------------------------------------------------------------------

-- Cuenta de acceso -----------------------------------------------------------
DROP USER IF EXISTS 'ISCuenta'@'localhost'; 
CREATE USER 'ISCuenta'@'localhost' IDENTIFIED BY 'Escom_17';
GRANT ALL PRIVILEGES ON Biblioteca_Personas . * TO 'ISCuenta'@'localhost';
-- ----------------------------------------------------------------------------
