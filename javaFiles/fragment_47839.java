int newDirectorID; // YOU NEED TO PROVIDE A VALUE
        stat = conn.prepareStatement("UPDATE Movie_Directors SET director_id = ?, movie_id = ? WHERE director_id = ? AND movie_id = ?"); 
        stat.setInt(1, newDirectorID);
        stat.setInt(2, movieID);
        stat.setInt(3, directorID);
        stat.setInt(4, movieID);

        int result = stat.executeUpdate();