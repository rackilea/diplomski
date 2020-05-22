CREATE TABLE tag_dt (
    tag_id      integer     NOT NULL,
    dt_id       integer     NOT NULL,
    CONSTRAINT p_tag_dt PRIMARY KEY (tag_id, dt_id),
    CONSTRAINT f_tag_id FOREIGN KEY (tag_id) REFERENCES tag,
    CONSTRAINT f_dt_id FOREIGN KEY (dt_id) REFERENCES dt
);