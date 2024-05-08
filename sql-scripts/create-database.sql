DROP TABLE IF EXISTS instructor_detail;

CREATE TABLE instructor_detail
(
    id SERIAL PRIMARY KEY,
    youtube_channel VARCHAR(128) DEFAULT NULL,
    hobby VARCHAR(45) DEFAULT NULL
);

DROP TABLE IF EXISTS instructor;

CREATE TABLE instructor
(
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(45) DEFAULT NULL,
    last_name VARCHAR(45) DEFAULT NULL,
    email VARCHAR(45) DEFAULT NULL,
    instructor_detail_id INT DEFAULT NULL,
    CONSTRAINT fk_instructor_detail
        FOREIGN KEY (instructor_detail_id)
            REFERENCES instructor_detail(id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);