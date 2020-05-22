-- LOAD some data
-- CLASSES
INSERT INTO classes (class_name, class_codename) VALUES('English Language','EL100');
INSERT INTO classes (class_name, class_codename) VALUES('English Literature','EL101');
INSERT INTO classes (class_name, class_codename) VALUES('Applied Mathermatics','MA200');
INSERT INTO classes (class_name, class_codename) VALUES('Pure Mathematics','MA201');
INSERT INTO classes (class_name, class_codename) VALUES('Chemistry','SC300');
INSERT INTO classes (class_name, class_codename) VALUES('Physics','SC301');
INSERT INTO classes (class_name, class_codename) VALUES('Biology','SC302');
INSERT INTO classes (class_name, class_codename) VALUES('GEOGRAPHY','GE400');
-- SECTIONS
INSERT INTO sections (section_name, section_description) VALUES('Class Introduction','Evacuation procedures, amenities etc..');
INSERT INTO sections (section_name, section_description) VALUES('Sentence Construction','Blah');
INSERT INTO sections (section_name, section_description) VALUES('Word types','Basic word types such as VERB, ADJECTIVE etc');
INSERT INTO sections (section_name, section_description) VALUES('Puntuation','Blah');
INSERT INTO sections (section_name, section_description) VALUES('Under Milk Wood','Blah');
INSERT INTO sections (section_name, section_description) VALUES('Catcher in the Rye','Blah');
INSERT INTO sections (section_name, section_description) VALUES('The War of the Worlds','Blah');
-- CLASS SECTION LINKS (note assumes ID's of classes/sections in order 1,2,3......)
-- a) All classes have Class Introduction
INSERT INTO class_section_links VALUES(1,1); -- Class 1 English language
INSERT INTO class_section_links VALUES(2,1); -- Class 2 English Lit
INSERT INTO class_section_links VALUES(3,1);
INSERT INTO class_section_links VALUES(4,1);
INSERT INTO class_section_links VALUES(5,1);
INSERT INTO class_section_links VALUES(6,1);
INSERT INTO class_section_links VALUES(7,1);
INSERT INTO class_section_links VALUES(8,1);
-- b) specific sections
INSERT INTO class_section_links VALUES(1,2); -- Class 1 has section 2
INSERT INTO class_section_links VALUES(1,3); -- Class 1 has section 3
INSERT INTO class_section_links VALUES(2,4);
INSERT INTO class_section_links VALUES(2,5);
INSERT INTO class_section_links VALUES(2,6);
INSERT INTO class_section_links VALUES(2,7);