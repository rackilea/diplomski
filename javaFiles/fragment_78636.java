public Field getCurrentField()
{
    ArrayList<Position> positions = this.getManager().getPinPositions();
    //Just create a new list
    ArrayList<Position> matchedPositions = new ArrayList<Position>();
    //Use the for-each syntax to iterate over the iterator
    for (Position position : positions) {
        //switch the logic and add to the new list
        if (position.getPin().equals(this))
            matchedPositions.add(position);
    }

    if(matchedPositions.size() > 0)
        return matchedPositions.get(0).getField();
    else
        return null;
}