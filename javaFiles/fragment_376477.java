CREATE TABLE tag (
    tag_id      integer     NOT NULL,
    tag_name    varchar(50) NOT NULL,
    CONSTRAINT p_tag PRIMARY KEY (tag_id),
    CONSTRAINT u_tag_name UNIQUE (tag_name)
);