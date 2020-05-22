ArrayList<Runnable> requests = new ArrayList<>;
bool inProgress = false;
private void displayMsg(){
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Toast.makeText(this, "TestQueue", Toast.LENGTH_SHORT).show();
            inProgress = false;
            if (requests.size() > 0) {
                handler.postDelayed(requests.remove(0), 3000 + Toast.LENGTH_SHORT);
            }
        }
    }
    if (!inProgress) {
        inProgress = true;
        handler.postDelayed(runnable, 3000);
    } else {
        requests.add(runnable);
    }
}