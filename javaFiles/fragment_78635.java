public Field getCurrentField()
{
    ArrayList<Position> positions = this.getManager().getPinPositions();

    for (Iterator<Position> it=positions.iterator(); it.hasNext();) {
        if (!it.next().getPin().equals(this))
            it.remove();
    }

    if(positions.size() > 0)
        return positions.get(0).getField();
    else
        return null;
}