protected void onStop() {
        super.onStop();
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }