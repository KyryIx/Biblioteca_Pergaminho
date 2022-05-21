-- https://www.w3schools.com/sql/default.asp
-- https://dev.mysql.com/doc/refman/8.0/en/create-table.html

CREATE DATABASE biblioteca;

CREATE TABLE livros (
	id                  INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	isbn                VARCHAR(13)           COMMENT 'ISBN da obra como um todo (8536301236 => 85-363-0123-6)', 
	ccd                 VARCHAR(64)           COMMENT 'Notacao assunto-CDD (005.13)',
	cutter              VARCHAR(64)           COMMENT 'Notação de autor-Cutter (D325j)',
	colecao             VARCHAR(64)           COMMENT 'Informação de colecao (Livros)',
	autor_principal     VARCHAR(255) NOT NULL COMMENT 'Sobrenome e/ou prenomes (DEITEL, Harvey M.)',
	titulo              VARCHAR(255) NOT NULL COMMENT 'Título (Java - Como programar)',
	edicao              VARCHAR(255) NOT NULL COMMENT 'Edicao (4. ed.)',
	cidade              VARCHAR(255) NOT NULL COMMENT 'Local de publicacao (Porto Alegre)',
	editora             VARCHAR(255) NOT NULL COMMENT 'Editor ou publicador (Bookman Companhia Editora)',
	ano                 INTEGER      NOT NULL COMMENT 'Data da publicação (2003)',
	paginas             INTEGER               COMMENT 'Paginacao (1386 p.)',
	assunto             VARCHAR(255)          COMMENT 'Assunto tópico (Programação de internet; Programação de computadores;)',
	autores_secundarios VARCHAR(255)          COMMENT 'Sobrenome e/ou prenome (DEITEL, Paul J.;LISBÔA, Carlos Arthur Lang (Tradutor))',
	campus              VARCHAR(255)          COMMENT 'Campus (FAMEBLU)',
	nota                VARCHAR(255)          COMMENT 'Nota ()'
);

INSERT INTO livros(
	isbn,ccd,cutter,colecao,autor_principal,titulo,edicao,
	cidade,editora,ano,paginas,assunto,autores_secundarios,campus,nota)
VALUES(
	'8536301236', '005.13', 'D325j', 'Livros', 'DEITEL, Harvey M.',
	'Java - Como programar', '4. ed.', 'Porto Alegre',
	'Bookman Companhia Editora', 2003, 1386,
	'Programação de internet; Programação de computadores',
	'DEITEL, Paul J.;LISBÔA, Carlos Arthur Lang (Tradutor)',
	'FAMEBLU', '');

INSERT INTO livros(
	isbn,ccd,cutter,colecao,autor_principal,titulo,edicao,
	cidade,editora,ano,paginas,assunto,autores_secundarios,campus,nota)
VALUES(
	'9788560166138', '391', 'M672c', 'Livros', 'MIRANDA, Ana Paula de',
	'Consumo de moda', '2. ed.', 'São Paulo',
	'Estação das Letras e Cores', 2014, 127,
	'Moda; Consumo; Marketing da moda; Relações de Objeto','',
	'FAMEBLU', 'Possui referências');