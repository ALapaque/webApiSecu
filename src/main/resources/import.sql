INSERT INTO Roles(name) VALUES ('ADMIN'),('USER');
INSERT INTO user_api(username, password) VALUES ('amaury','$2a$10$OX52PKEhFLdVawNVpwj7ROwCO0xLtS5N7m26j8DWik80FVJx6Hr5a'),('toto','$2a$10$OX52PKEhFLdVawNVpwj7ROwCO0xLtS5N7m26j8DWik80FVJx6Hr5a');
INSERT INTO user_api_roles(users_id, roles_id) VALUES (1,1),(1,2),(2,1);
INSERT INTO Items(name, prix) VALUES ('Clavier', 15.99),('Ecran', 145.50),('Souris', 69.00);