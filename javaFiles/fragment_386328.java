public static void rechercheRating() {

        System.out.println("======= Ratings menu =========");
        System.out.println("\t 'G' ");
        System.out.println("\t 'PG' ");
        System.out.println("\t 'PG-13' ");
        System.out.println("\t 'R' ");
        System.out.println("\t 'NC-17' ");
        System.out.println("Entrez le rating désiré :");
        String userInput = sc.nextLine().toUpperCase();

        try {
            int foovalue = 10;

            PreparedStatement st = conn.prepareStatement("SELECT title, 
            rating FROM film WHERE (rating = ?::mpaa_rating);"); //added cast

            st.setString(1, userInput);

            ResultSet rs = st.executeQuery();
            System.out.printf("%-20s %-15s\n", "Film", "Rating");

            while (rs.next()) {

                System.out.printf("%-20s %-15s\n", rs.getString(1), rs.getString(2));

            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(DVDrental.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//rechercheRating