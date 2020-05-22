for (Room room : rooms)
{
       theString = theString + room.getRoomData() + "\n";
       if (room.available) {
           System.out.println(theString);
       }
}