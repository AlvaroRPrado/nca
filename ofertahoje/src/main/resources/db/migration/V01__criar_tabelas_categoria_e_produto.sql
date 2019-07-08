CREATE TABLE categoria (
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE produto (
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    sku VARCHAR(50) NOT NULL,
    nome VARCHAR(80) NOT NULL,
   marca VARCHAR(80) NOT NULL,
  descricao TEXT NOT NULL,
valor DECIMAL(10, 2) NOT NULL,
     novo_valor DECIMAL(10, 2) NOT NULL,
    origem VARCHAR(50) NOT NULL,
    quantidade_estoque INTEGER,
    foto VARCHAR(100),
content_type VARCHAR(120),
    codigo_categoria BIGINT(20) NOT NULL,
    FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO categoria VALUES (0, 'açougue');
INSERT INTO categoria VALUES (0, 'verduras');
INSERT INTO categoria VALUES (0, 'padaria');
INSERT INTO categoria VALUES (0, 'frutas');