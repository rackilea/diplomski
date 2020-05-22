private boolean getAnswer()
{
   System.out.println("Would you lioke to play a game enter yes to play or no to exit a game");
    mAnswer = mScanner.nextLine();

    if (mAnswer.equals("no"))
    {
        System.out.println("Maybe next time");
        sayGoodbye();
        return false;
    }

    return true;
}