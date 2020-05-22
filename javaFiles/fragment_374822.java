create table Record (
    id integer not null,
    primary key (id)
);

create table RecordNotification (
    id integer not null,
    record_id integer,
    primary key (id)
);

alter table RecordNotification 
    add constraint FKE88313FC6EE389C1 
    foreign key (record_id) 
    references Record;