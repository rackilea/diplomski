CREATE TABLE tag_property (
    tag_id      integer     NOT NULL,
    dt_id       integer     NOT NULL,
    property_id integer     NOT NULL,
    a_value     varchar(50) NOT NULL,
    CONSTRAINT p_tag_property PRIMARY KEY (tag_id, dt_id),
    CONSTRAINT u_tag_property UNIQUE (tag_id, property_id),
    CONSTRAINT f_tag_property_tag FOREIGN KEY (tag_id, dt_id) REFERENCES tag_dt,
    CONSTRAINT f_tag_property_property FOREIGN KEY (dt_id, property_id)
      REFERENCES dt_property
);