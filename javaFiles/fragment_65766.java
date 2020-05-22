@Override
    public void onAddEventClicked(Calendar startTime, Calendar endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        Intent intent = new Intent(this, Test2.class);
        startActivityForResult(intent, REQUEST_CODE);
    }