INSERT INTO asociaciones (nombre, pais, presidente) VALUES
('FCF', 'Colombia', 'Ramón Jesurún'),
('FIFA', 'Suiza', 'Gianni Infantino'),
('CONMEBOL', 'Paraguay', 'Alejandro Domínguez'),
('UEFA', 'Suiza', 'Aleksander Ceferin'),
('Dimayor', 'Colombia', 'Fernando Jaramillo');

INSERT INTO entrenadores (nombre, apellido, edad, nacionalidad) VALUES
('Alberto', 'Gamero', 58, 'Colombiano'),
('Hernán', 'Crespo', 48, 'Argentino'),
('Alexandre', 'Guimaraes', 62, 'Costarricense'),
('Jorge', 'Almirón', 55, 'Argentino'),
('Julio', 'Comesaña', 73, 'Uruguayo');

INSERT INTO competiciones (nombre, monto_premio, fecha_inicio, fecha_fin) VALUES
('Liga BetPlay 2024', 500000, '2024-01-20', '2024-12-15'),
('Copa Colombia 2024', 200000, '2024-02-01', '2024-11-30'),
('Copa Libertadores 2024', 23000000, '2024-02-07', '2024-11-30'),
('Copa Sudamericana 2024', 7000000, '2024-02-21', '2024-11-27'),
('Superliga Colombia 2024', 150000, '2024-01-10', '2024-02-10');

INSERT INTO clubes (nombre, ciudad, anio_fundacion, entrenador_id, asociacion_id) VALUES
('Millonarios FC', 'Bogotá', 1946, 1, 1),
('Atlético Nacional', 'Medellín', 1947, 2, 1),
('America de Cali', 'Cali', 1927, 3, 1),
('Independiente Medellín', 'Medellín', 1913, 4, 1),
('Junior FC', 'Barranquilla', 1924, 5, 1);

INSERT INTO club_competicion (club_id, competicion_id) VALUES
(1, 1), (1, 2), (1, 3),
(2, 1), (2, 2), (2, 3),
(3, 1), (3, 2), (3, 4),
(4, 1), (4, 4),
(5, 1), (5, 2), (5, 5);