for(int x =0; ;x++) {
    index = x;
    if(sharedPreferences.contains(String.valueOf(x))){
        temp = gson.fromJson(sharedPreferences.getString(String.valueOf(x), null), PointOfInterest.class);
        pointList.add(temp);
    }
    else {
        break;
    }
}