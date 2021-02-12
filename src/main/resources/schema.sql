DROP TABLE IF EXISTS users_new;
DROP TABLE IF EXISTS authorities_new;

CREATE TABLE IF NOT EXISTS users_new (
 id SERIAL PRIMARY KEY,
 username VARCHAR(45) NOT NULL,
 password VARCHAR(45) NOT NULL,
 enabled INTEGER NOT NULL DEFAULT '1',
 UNIQUE (username)
);

CREATE TABLE IF NOT EXISTS authorities_new (
    id SERIAL PRIMARY KEY,
    username VARCHAR(45) NOT NULL,
    authority VARCHAR(45) NOT NULL,
    UNIQUE (username, authority)
);
