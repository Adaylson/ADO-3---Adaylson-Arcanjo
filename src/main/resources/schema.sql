DROP TABLE IF EXISTS CAR;

CREATE TABLE IF NOT EXISTS car (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  nome              VARCHAR(255),
  cor               VARCHAR(255),
  marca             VARCHAR(255),
  modelo            VARCHAR(255),
  ano_fabricacao    VARCHAR(255),
  ano_modelo        VARCHAR(255)
);