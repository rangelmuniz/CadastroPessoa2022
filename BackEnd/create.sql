create table pessoa (id int8 generated by default as identity, nome varchar(255), genero varchar(1), idade numeric(19, 2), primary key (id));
INSERT INTO pessoa(nome, genero, idade) VALUES('Pedro','M', 10);
INSERT INTO pessoa(nome, genero, idade) VALUES('Paulo', 'M', 20);
INSERT INTO pessoa(nome, genero, idade) VALUES('Alice', 'F', 30);
INSERT INTO pessoa(nome, genero, idade) VALUES('Camila','F', 40);

