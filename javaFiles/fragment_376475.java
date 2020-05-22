CREATE TABLE dt (
    dt_id       integer     NOT NULL,
    dt_name     varchar(50) NOT NULL,
    CONSTRAINT p_dt PRIMARY KEY (dt_id),
    CONSTRAINT u_dt_name UNIQUE (dt_name)
);