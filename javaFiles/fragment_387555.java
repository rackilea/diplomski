public class FortuneBox {

    public String[] mFortunes;

    public FortuneBox(Context context) {
        Resources resources = context.getResources();
        mFortunes = resources.getStringArray(R.array.emo_fortunes);
    }

    // Methods (abilities)
    public String getFortune() {

        String fortune = "";

        // Randomly select a fortune
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(mFortunes.length);

        fortune = mFortunes[randomNumber];

        return fortune;
    }
}