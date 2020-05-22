create type admins.admin_role as enum ('ADMIN','ORGANIZATION_ADMIN');

 create table admins.admin (
    admin_id            uuid        not null,
    name                text        not null,
    first_name          text        not null,
    last_name           text        not null,
    admin_role          admins.admin_role,
    created             timestamp   not null,
    last_modified       timestamp   not null,
    created_by          uuid        not null references admins.admin(admin_id) deferrable initially deferred,
    last_modified_by    uuid        not null references admins.admin(admin_id) deferrable initially deferred,
    delete              boolean     not null default false,
    primary key (admin_id),
    constraint empty_name_check check ((length(name) >= 1) and (name not like 'null')),
    constraint empty_first_name_check check ((length(first_name) >= 1) and (name not like 'null')),
    constraint empty_last_name_check check ((length(last_name) >= 1) and (name not like 'null'))
    );