for (int i = 0; i < movies.length; i++) {
        for (int j = i; i < movies.length; j++) {
            if (Double.compare(Double.parseDouble(movies[i][4]), Double.parseDouble(movies[j][4])) >= 0) {
                //swap movies[i] and movies[j]
                String[] temp = movies[i];
                movies[i] = movies[j];
                movies[j] = temp;
            }
        }
    }