void ChangeStartValue(){

        Room = FirebaseDatabase.getInstance().getReference("Matchmaking");
        try {
            ct.setStart(true);
            Room.child(ct.getId()).setValue(ct);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void switchToScreen(int screenId) {
        // make the requested screen visible; hide all others.
        for (int id : SCREENS) {
            findViewById(id).setVisibility(screenId == id ? View.VISIBLE : View.GONE);
        }
    }