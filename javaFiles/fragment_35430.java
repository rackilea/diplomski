CREATE TABLE student_list
(course_id VARCHAR(6) NOT NULL,
semester VARCHAR(6) NOT NULL CONSTRAINT sem_constraint2 CHECK (semester IN ('1st','2nd','module')),
school_year DATE NOT NULL,
id_number INT NOT NULL,
CONSTRAINT student_list_pk PRIMARY KEY (course_id, semester, school_year, id_number),
CONSTRAINT student_list_fk1 FOREIGN KEY (course_id, semester, school_year)
REFERENCES class_t (course_id, semester, school_year),
CONSTRAINT student_list_fk2 FOREIGN KEY (id_number)
REFERENCES student_t (id_number)
);