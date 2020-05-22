private final static int POSITIONS_ARRAY_SIZE = 3; //Global constant in the Activity.


    String closestPosition = null;
    String closestPosition2 = null;
    String closestPosition3 = null;
    ArrayList<Router> wifis = db.getFriendlyWifis(building);
    boolean flagPositionInserted;

    ArrayList<Integer> min_distance_positions = new ArrayList<>();
    //Get the first value (position = 0).
    double min_distance = positionData.uDistance(positionsData.get(0), wifis);
    min_distance_positions.add(0);
    String res = "";
    res += closestPosition + "\n" + min_distance;
    res += "\n" + positionsData.get(0).toString();

    //Iterate through the datalist (positionsData).
    for (int i = 1; i < positionsData.size(); i++) {
        double distance = positionData.uDistance(positionsData.get(i), wifis);
        res += "\n" + positionsData.get(i).getName() + "\n" + distance;
        res += "\n" + positionsData.get(i).toString();

        flagPositionInserted = false;
        //Iterate through the sorted list (min_distance_positions).
        for (int j = 0; j < min_distance_positions.size(); j++){
            if (distance < positionData.uDistance(positionsData.get(min_distance_positions.get(j)), wifis)) {
                min_distance_positions.add(j, i);
                flagPositionInserted = true;
                break;
            }
        }
        if (!flagPositionInserted) {
            if (min_distance_positions.size() < POSITIONS_ARRAY_SIZE) {
                min_distance_positions.add(i);
            }
        }
    }

    //min_distance_positions.size() should be less or equal to 3(POSITIONS_ARRAY_SIZE).
    //min_distance_positions.get(0) is the closestPosition.
    //min_distance_positions.get(1) is the 2nd closestPosition.
    //min_distance_positions.get(2) is the 3rd closestPosition.
    String msg = "";
    for (int i = 0; i < min_distance_positions.size(); i++){
        msg += min_distance_positions.get(i) + ", ";
    }
    Log.v("Result", "Position ArrayList Content: " + msg);

    closestPosition = positionsData.get(min_distance_positions.get(0)).getName();
    if (positionData.uDistance(positionsData.get(min_distance_positions.get(0)), wifis) >= PositionData.MAX_DISTANCE){
        closestPosition="OUT OF RANGE";
        Toast.makeText(this,"You are out of range of the selected building",Toast.LENGTH_LONG).show();
    }
    result.setText("Nearest point :  "+ closestPosition);
    res += "\nCurrent:\n" + positionData.toString();
    Log.v("Result", res);

    closestPosition2 = positionsData.get(min_distance_positions.get(1)).getName();
    if (positionData.uDistance(positionsData.get(min_distance_positions.get(1)), wifis) >= PositionData.MAX_DISTANCE){
        closestPosition2="OUT OF RANGE";
        Toast.makeText(this,"You are out of range of the selected building",Toast.LENGTH_LONG).show();
    }
    result2.setText("Nearest point :  "+ closestPosition2);
    closestPosition3 = positionsData.get(min_distance_positions.get(2)).getName();
    if (positionData.uDistance(positionsData.get(min_distance_positions.get(2)), wifis) >= PositionData.MAX_DISTANCE){
        closestPosition3="OUT OF RANGE";
        Toast.makeText(this,"You are out of range of the selected building",Toast.LENGTH_LONG).show();
    }
    result3.setText("Nearest point :  "+ closestPosition3);