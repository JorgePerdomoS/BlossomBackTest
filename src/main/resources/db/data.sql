CREATE TABLE weather (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         city VARCHAR(100) NOT NULL,
                         temperature_value DOUBLE NOT NULL,
                         temperature_unit VARCHAR(10) NOT NULL,
                         condition VARCHAR(100) NOT NULL,
                         wind_speed DOUBLE NOT NULL,
                         wind_unit VARCHAR(10) NOT NULL
);

CREATE TABLE audit (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       city VARCHAR(100) NOT NULL,
                       timestamp TIMESTAMP NOT NULL,
                       status VARCHAR(50),
                       source VARCHAR(100),
                       error TEXT
);

INSERT INTO weather (
    city, temperature_value, temperature_unit, condition, wind_speed, wind_unit
) VALUES
      ('Bogotá', 18.5, '°C', 'Nublado', 12.4, 'km/h'),
      ('Medellín', 24.0, '°C', 'Soleado', 8.0, 'km/h'),
      ('Cali', 30.2, '°C', 'Parcialmente nublado', 10.1, 'km/h');
