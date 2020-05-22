(JSONObject) Square = (JSONObject)jsonObject.get("Square");
    System.out.println("Square: " + Square);
    System.out.println("Square: Length=" + Square.get("Length"));

    JSONObject rect =  (JSONObject)jsonObject.get("Rectangle");
    System.out.println("Rectangle: " + rect);
    System.out.printf("Rectangle: Length=%s Width=%s%n",
      rect.get("Length"), rect.get("Width"));