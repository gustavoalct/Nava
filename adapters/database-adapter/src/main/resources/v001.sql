CREATE TABLE IF NOT EXISTS endereco (
    cep VARCHAR(10) NOT NULL,
    logradouro VARCHAR(255),
    complemento VARCHAR(255),
    unidade VARCHAR(50),
    bairro VARCHAR(100),
    localidade VARCHAR(100),
    uf VARCHAR(2),
    estado VARCHAR(100),
    regiao VARCHAR(100),
    ibge VARCHAR(20),
    gia VARCHAR(20),
    ddd VARCHAR(3),
    siafi VARCHAR(20),
    PRIMARY KEY (cep)
);

CREATE INDEX IF NOT EXISTS  idx_endereco_cep ON endereco (cep);