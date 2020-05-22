create table elecciones2014.JRV (
    id_jrv  serial not null,
    id_depto varchar(255),
    id_municipio varchar(255),
    primary key (id_jrv)
);

alter table elecciones2014.JRV 
    add constraint FK_7scd8alu3nf4tsyh3hq2ryrja 
    foreign key (id_depto, id_municipio) 
    references elecciones2014.Municipio;