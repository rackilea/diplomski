for(int i=0;i<coordinateArray.length();i++)
    {
        brokenArray= coordinateArray.getJSONObject(i);  
        x=brokenArray.getInt("x");
        y=brokenArray.getInt("y");

        Log.d("x", " "+i+ " "+x );
        Log.d("y", " "+i+ " "+y );
        Coordinate coord = new Coordinate ();
        coord.set(x, y);

        pointList.add(i , coord);

        Log.d("pointList", pointList.toString());
    }