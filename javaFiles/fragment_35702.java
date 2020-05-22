public int onStartCommand(Intent intent, int flags, int startId) {
    int score = (int) intent.getExtras().get("asdf");

    Log.i("retrieve", "retrieved value: " + score);
    return score;
}