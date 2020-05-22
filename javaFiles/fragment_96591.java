String stmt = "insert into Table1(movie_Id,movie_name,user_name,rating,genre) values(?,?,?,?,?) "
                            + "ON DUPLICATE KEY UPDATE "
                            + "movie_name=VALUES(movie_name), user_name=VALUES(user_name), "
                            + "rating=VALUES(rating), genre=VALUES(genre) "

PreparedStatement ps = connection.prepareStatement(stmt);
ps.setObject(1, movie_id);
ps.setObject(2, movie_name);
ps.setObject(3, user_name);
ps.setObject(4, rating);
ps.setObject(5, genre);
ResultSet rs = ps.executeQuery();