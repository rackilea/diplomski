String placeOne = "";
String placeTwo = "";

 if (rs.next())
      {
        placeOne = rs.getString("Place1");
        placeTwo = rs.getString("Place2"); 
        System.out.println("place1" +placeOne);
        System.out.println("place1" +placeTwo);
      }