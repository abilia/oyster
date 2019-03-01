CREATE TABLE persons(id integer primary key, full_name varchar(30));
CREATE TABLE occupations(person_id integer, company_id integer, occupation varchar(30));
CREATE TABLE companies(id integer primary key, name varchar(30), city varchar(30));