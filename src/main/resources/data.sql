INSERT INTO persons(id, full_name) values (1, 'Harry Potter');
INSERT INTO persons(id, full_name) values (2, 'Severus Snape');
INSERT INTO persons(id, full_name) values (3, 'Hermione Granger');
INSERT INTO persons(id, full_name) values (4, 'Minerva McGonagall');
INSERT INTO persons(id, full_name) values (5, 'Albus Dumbledore');

INSERT INTO companies(id, name, city) values (1, 'Abilia', 'Gothenburg');
INSERT INTO companies(id, name, city) values (2, 'Abilia', 'Stockholm');

INSERT INTO occupations(person_id, company_id, occupation) VALUES (2, 1, 'Teacher');
INSERT INTO occupations(person_id, company_id, occupation) VALUES (3, 1, 'Student');
INSERT INTO occupations(person_id, company_id, occupation) VALUES (4, 2, 'Teacher');
INSERT INTO occupations(person_id, company_id, occupation) VALUES (5, 1, 'Principal');