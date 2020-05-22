public void checkIn (String roomNo, String guest) {
       if (validRoom(roomNo)) {
        if (!roomTaken(roomNo)) {
            System.out.println(guest + " booked in to room number: " + roomNo);
            occupiedRooms.add(new Room(roomNo,guest));
           }
        }
    }


public boolean roomTaken (String roomNo){
        if(!(occupiedRooms.contains(roomNo))){
            return false;
        }
        else{
            return true;

        }

    }