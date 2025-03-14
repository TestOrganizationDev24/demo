CREATE TABLE users
(
    id         SERIAL PRIMARY KEY,
    username   VARCHAR(50) UNIQUE NOT NULL,
    password   VARCHAR(64)        NOT NULL,
    email      VARCHAR(100)       NOT NULL UNIQUE,
    first_name VARCHAR(50),
    last_name  VARCHAR(50)
);

CREATE TABLE roles
(
    id          SERIAL PRIMARY KEY,
    username    VARCHAR(50) NOT NULL,
    role_name   VARCHAR(50) NOT NULL,
    description TEXT,
    FOREIGN KEY (username) REFERENCES users (username) ON DELETE CASCADE
);


-- Inserting test users
INSERT INTO users (username, password, email, first_name, last_name)
VALUES
    ('john_doe', '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5', 'john.doe@example.com', 'John', 'Doe'),
    ('jane_smith', '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5', 'jane.smith@example.com', 'Jane', 'Smith'),
    ('admin_user', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', 'admin@example.com', 'Admin', 'User');

-- Inserting test roles
INSERT INTO roles (username, role_name, description)
VALUES
    ('john_doe', 'GUEST', 'Regular user with limited access'),
    ('jane_smith', 'GUEST', 'Regular user with limited access'),
    ('admin_user', 'ADMIN', 'Administrator with full access');