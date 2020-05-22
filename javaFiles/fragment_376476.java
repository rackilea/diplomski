CREATE TABLE dt_property (
    dt_id           integer     NOT NULL,
    property_id     integer     NOT NULL,
    initial_value   varchar(50) NOT NULL,
    CONSTRAINT p_dt_property PRIMARY KEY (dt_id, property_id),
    CONSTRAINT f_dt_id FOREIGN KEY (dt_id) REFERENCES dt,
    CONSTRAINT f_property_id FOREIGN KEY (property_id) REFERENCES property
);