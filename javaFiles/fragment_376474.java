CREATE TABLE property (
    property_id     integer     NOT NULL,
    property_name   varchar(50) NOT NULL,
    property_type   varchar(20) NOT NULL,
    CONSTRAINT p_property PRIMARY KEY (property_id),
    CONSTRAINT u_property_name UNIQUE (property_name),
    CONSTRAINT f_property_type FOREIGN KEY (property_type)
      REFERENCES property_type ON UPDATE CASCADE
);