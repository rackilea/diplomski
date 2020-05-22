CREATE UNLOGGED TABLE sessions (
  token      text DEFAULT uuid_generate_v4()::text,
  login_time timestamp DEFAULT CURRENT_TIME,
  user_name  integer,
  ...
);