for (int i=0; i<10; i++)
    {
     randP = minP + (int)(Math.random()*(maxP));
     randNum = minN + (int)(Math.random()*(maxN));
        if(s1.getNumOfSticks() > randNum)
        {
        System.out.println("Computer player " + randP + " choose " + randNum + " sticks ");
        s1.remove(randNum);
        }
        else
        {
            System.out.println("Computer player " + randP + " wants to choose " + randNum + " sticks but is unable to.");
            System.out.println("Computer player " + randP + " loses ");
        }
    }

}