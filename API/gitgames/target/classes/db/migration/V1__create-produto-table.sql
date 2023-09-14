CREATE TABLE produto(
    id serial PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    plataforma VARCHAR(30) NOT NULL,
    descricao VARCHAR(1000) NOT NULL,
    estoque INT NOT NULL
    );