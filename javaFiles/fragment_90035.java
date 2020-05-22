create table  User_tab (
    login varchar2(100),
    password_hash raw(100), 
    CONSTRAINT User_tab_pk PRIMARY KEY (login)
);

create table Role_tab (
    id Int,
    name varchar2(100),
    CONSTRAINT Role_tab_pk PRIMARY KEY (id)
); 

create table User_Role_tab (
    login varchar2(100),
    id Int,
    CONSTRAINT User_Role_tab_pk PRIMARY KEY (login,id),
    CONSTRAINT User_Tab_fk FOREIGN KEY (login) REFERENCES User_tab(login),
    CONSTRAINT Role_tab_fk FOREIGN KEY (id) REFERENCES Role_tab(id)    
);