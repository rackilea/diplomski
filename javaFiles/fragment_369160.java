public List<TenantInformation> roomforGuest() {
    for (Guest g: this.resultThue){
        int min = Integer.MAX_VALUE;
        Room selectedRoom = null;

        TenantInformation tt = new TenantInformation();
        for (Room r: this.resultInit) {
            if(g.getGuestNum()-k.getRoomSeat() < min) {
                min = Math.abs(g.getGuestNum() - r.getRoomSeat());
                selectedRoom = r;
            }
        }

        tt.setGuestName(g.getGuestName());
        tt.setRoomName(selectedRoom.getRoomName());
        selectedRoom.setRoomStatus(1);
        resultttkt.add(tt);
    }
}