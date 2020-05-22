class TypeRateCalculator(){
    private Date startTime;
    private Date elapsedTime;
    private int characterCount = 0;

    public void startMeasuring() {
        startTime = new Date();
    }

    public int updateTypingRate() {
        characterCount++;
        elapsedTime = new Date();
        long delta = (elapsedTime.getTime() - startTime.getTime()) / 1000 / 60;
        int typingRate = Math.max(0, (int) (characterCount/ delta ));
        return typingRate;
    }
}