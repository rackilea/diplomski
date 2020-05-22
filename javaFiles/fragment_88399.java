DROP TABLE IF EXISTS Anuncio;
CREATE TABLE IF NOT EXISTS Anuncio( 
    ID INTEGER PRIMARY KEY AUTOINCREMENT,
    USER_ID INTEGER NOT NULL,
    Anuncio_perfil TEXT NOT NULL,
    Anuncio_empregado_info_ID INTEGER,
    ANUNCIO_PRESTADOR_ID INTEGER,
    CREATED_AT DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);


DROP TABLE IF EXISTS Anuncio_empregador;
CREATE TABLE IF NOT EXISTS Anuncio_empregador (
    ID INTEGER PRIMARY KEY,
    Titulo TEXT NOT NULL,
    Descricao TEXT NOT NULL,
    Bairro TEXT NOT NULL,
    Cidade TEXT NOT NULL,
    Estado TEXT NOT NULL,
    Local_Servico TEXT NOT NULL,
    Exigencias TEXT,
    Imagem_anuncio BLOB NOT NULL DEFAULT X'00010203040506070809'
)
;   

INSERT INTO Anuncio_empregador 
    (Titulo,Descricao,Bairro,Cidade,Estado,Local_Servico,Exigencias)
    VALUES
        ('Mr','Albert','Bloggs','something','something else','xxx','xxxx'),
        ('Mr','Bert','Bloggs','something','something else','xxx','xxxx'),
        ('Mr','Charlie','Bloggs','something','something else','xxx','xxxx'),
        ('Mr','Dave','Bloggs','something','something else','xxx','xxxx'),
        ('Mr','Eddie','Bloggs','something','something else','xxx','xxxx'),
        ('Mr','Fred','Bloggs','something','something else','xxx','xxxx'),
        ('Mr','George','Bloggs','something','something else','xxx','xxxx')
    ;

SELECT * FROM Anuncio_empregador;

INSERT INTO Anuncio
    (USER_ID, Anuncio_perfil,Anuncio_empregado_info_ID,ANUNCIO_PRESTADOR_ID)
    VALUES
        (1,'empregador',1,100),
        (2,'empregador',2,100),
        (3,'empregador',3,100),
        (4,'not an empregador',1,100),
        (5,'not an empregador',2,100),
        (6,'not an empregador',3,100)
    ;

SELECT * FROM Anuncio;

SELECT * FROM Anuncio WHERE Anuncio_perfil = 'empregador';

SELECT ID,Imagem_anuncio,Titulo,Descricao,Cidade
FROM Anuncio_empregador
WHERE ID IN 
    (
        SELECT Anuncio_empregado_info_ID 
        FROM ANUNCIO 
        WHERE ANUNCIO_PERFIL = 'empregador' AND USER_ID = user_id
        )
;