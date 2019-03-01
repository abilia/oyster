CREATE TABLE IF NOT EXISTS persons(id integer primary key, full_name varchar(30));
CREATE TABLE IF NOT EXISTS occupations(person_id integer, company_id integer, occupation varchar(30));
CREATE TABLE IF NOT EXISTS companies(id integer primary key, name varchar(30), city varchar(30));