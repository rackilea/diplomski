CREATE TABLE so_services
 ( service_id            NUMBER NOT NULL,
   id_service_provider   NUMBER NOT NULL,
   valid_from            DATE NOT NULL,
   valid_to              DATE DEFAULT DATE '9999-12-31' NOT NULL,
   CONSTRAINT so_services_pk PRIMARY KEY ( service_id, id_service_provider ),
   CONSTRAINT so_services_c1 CHECK ( valid_from <= valid_to ) );

CREATE TABLE so_services_exported
 ( service_id            NUMBER NOT NULL,
   id_service_provider   NUMBER NOT NULL,
   valid_from            DATE NOT NULL,
   valid_to              DATE DEFAULT DATE '9999-12-31' NOT NULL,
   CONSTRAINT so_services_exported_pk PRIMARY KEY ( service_id ),
   CONSTRAINT so_services_exported_c1 CHECK ( valid_from <= valid_to ) );

CREATE TABLE so_services_export_cmds
 ( service_id            NUMBER NOT NULL,
   id_service_provider   NUMBER,
   cmd                   VARCHAR2(30) NOT NULL,
   valid_from            DATE,
   valid_to              DATE,
   CONSTRAINT so_services_export_cmds_pk PRIMARY KEY ( service_id, cmd ) );