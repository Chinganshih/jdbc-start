CREATE TABLE movie (
    id SERIAL PRIMARY KEY,
    mName TEXT NOT NULL,
    release_date DATE NOT NULL,
    unique (mName)
);