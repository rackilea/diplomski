public Hotel(Location l, <other fields>)
{
    // Set other fields
    this.location = l;
    l.addHotel(this);
}