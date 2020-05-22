CREATE TABLE User_Likes_Wallpaper (
     userId NUMBER(10) not null,
     wallpaperId NUMBER(10) not null);

 CREATE VIEW Wall_stats AS
     SELECT wallpaperId, count(*)
       FROM User_Likes_Wallpaper
      GROUP BY wallpaperId