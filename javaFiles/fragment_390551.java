CREATE TABLE user (
    username VARCHAR(50),
    password VARCHAR(50));
create schema quiz;
CREATE TABLE Quiz.Results (
    username VARCHAR(50),
    points INT, 
    FOREIGN KEY (username) 
    REFERENCES public.user(username));