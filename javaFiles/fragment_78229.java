DROP TABLE IF EXISTS classes;
CREATE TABLE IF NOT EXISTS classes ( class_id INTEGER PRIMARY KEY, class_name TEXT, class_codename TEXT );
DROP TABLE IF EXISTS sections;
CREATE TABLE IF NOT EXISTS sections ( section_id INTEGER PRIMARY KEY, section_name TEXT, section_description TEXT);
DROP TABLE IF EXISTS teachers;
CREATE TABLE IF NOT EXISTS teachers ( teacher_id INTEGER PRIMARY KEY, teacher_name TEXT);
DROP TABLE IF EXISTS students;
CREATE TABLE IF NOT EXISTS students ( student_id INTEGER PRIMARY KEY, student_name TEXT);
-- LINK TABLES 
-- Note usess column constraints to define foreign keys i.e. REFERENCES
DROP TABLE IF EXISTS class_section_links;
CREATE TABLE IF NOT EXISTS class_section_links (
    class_link INTEGER NOT NULL REFERENCES classes (class_id), 
    section_link INTEGER NOT NULL REFERENCES sections (section_id), 
    PRIMARY KEY (class_link, section_link));
DROP TABLE IF EXISTS class_teacher_links;
CREATE TABLE IF NOT EXISTS class_teacher_links (
    class_link INTEGER NOT NULL REFERENCES classes (class_id), 
    teacher_link INTEGER NOT NULL REFERENCES teachers (teacher_id), 
    PRIMARY KEY (class_link, teacher_link));
DROP TABLE IF EXISTS class_student_links;
CREATE TABLE IF NOT EXISTS class_student_links (
    class_link INTEGER NOT NULL REFERENCES classes (class_id),
    student_link INTEGER NOT NULL REFERENCES students (student_id),
    PRIMARY KEY (class_link, student_link));