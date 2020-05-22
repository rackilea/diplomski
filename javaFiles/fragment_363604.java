//initialize an ArrayList of LatLng type.
    ArrayList<LatLng> border = new ArrayList<LatLng>();

    if (dbops.connect(DB_URL, DB_USER, DB_PW).isValid(1)) {
        dbops.disconnect();
        prepst = dbops.connect(DB_URL, DB_USER, DB_PW)
                .prepareStatement(sql);
        rs = prepst.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            double x = rs.getDouble("x");
            double y = rs.getDouble("y");
            Log.e(Borders.class.getName(), id + " " + x + " " + y);
            LatLng ll = new LatLng(x, y); //Create a LatLng object to store the x,y doubles inside the array.
            border.add(ll); //add each x,y taken from the database into your ArrayList.

        }
        Log.e(Borders.class.getName(), "" + border); //check and make sure your arraylist was created succesfully.

        PolygonOptions rectOptions = new PolygonOptions().addAll(border)
                .strokeWidth((float) 1.5).fillColor(color); //take each item from the arraylist and add it to your polygon
        map.addPolygon(rectOptions);
        Log.e(Borders.class.getName(), "polygonadded");
        dbops.disconnect();
    }