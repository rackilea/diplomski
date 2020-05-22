CREATE TABLE IF NOT EXISTS users (
  id                      SERIAL PRIMARY KEY,
  username                VARCHAR(20) UNIQUE NOT NULL,
  password                VARCHAR(20) UNIQUE NOT NULL,
  account_non_expired     BOOLEAN            NOT NULL DEFAULT TRUE,
  account_non_locked      BOOLEAN            NOT NULL DEFAULT TRUE,
  credentials_non_expired BOOLEAN            NOT NULL DEFAULT TRUE,
  enabled                 BOOLEAN            NOT NULL DEFAULT TRUE
);