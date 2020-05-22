CREATE OR REPLACE FUNCTION fn_lisMatricula()
  RETURNS TABLE (codmatr integer,codal integer,codemp integer,codpre integer,codsec integer,fechamat date,
estadomat char,vigmat boolean,apeal varchar,nomal varchar,razonsocial varchar,codcur integer,curso varchar) AS
$BODY$
BEGIN
RETURN QUERY
SELECT mat.codigo as codmatr, mat.codigoalumno as codal, mat.codigoempresa as codemp ,mat.codigopresentacion as codpre,
    mat.codigosecretaria as codsec, mat.fecha as fechamat, mat.estado as estadomat,
    mat.vigencia as vigmat, p.apellidos as apeAl,
    p.nombres as nomAl,emp.razonsocial ,pre.codigocurso as codcur,cur.nombre as curso
    FROM matricula mat join alumno al on mat.codigoalumno = al.codigoalumno
    join persona p on  al.codigoalumno = p.codigo
    join persona pe on mat.codigoalumno = pe.codigo
    left join empresa emp on mat.codigoempresa = emp.codigo
    join presentacion pre on mat.codigopresentacion = pre.codigo
    join curso cur on cur.codigo = pre.codigocurso
    order by p.apellidos;
END
$BODY$ 
LANGUAGE plpgsql;

select * from fn_lisMatricula()