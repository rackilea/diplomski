public void onResult(QuestionAdResult questionAdResult) {

    Random random = new Random();
    int expOrHealth = random.nextInt(2);
    if (questionAdResult.wasCorrect()) {
        if (expOrHealth == 0)
        {
        // Additional Exp +5
        }
        if (expOrHealth == 1)
        {
             // Additional HP  +5
        }

        Hero.instance.earnExp(5);
        Hero.instance.earnHP(5);
        //
    } else {
        // Stuff
    }
}