SELECT ID,Imagem_anuncio,Titulo,Descricao,Cidade
FROM Anuncio_empregador
WHERE ID IN 
    (
        SELECT Anuncio_empregado_info_ID 
        FROM ANUNCIO 
        WHERE ANUNCIO_PERFIL = 'empregador' AND USER_ID = user_id
        )
;