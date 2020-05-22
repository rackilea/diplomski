// Using millis
class MyObj {
    private final long createdMillis = System.currentTimeMillis();

    public int getAgeInSeconds() {
        long nowMillis = System.currentTimeMillis();
        return (int)((nowMillis - this.createdMillis) / 1000);
    }
}