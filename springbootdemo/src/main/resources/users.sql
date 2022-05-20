DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id SERIAL,
    first_name varchar(10) NOT NULL,
    last_name varchar(15) NOT NULL,
    PRIMARY KEY (id)
)