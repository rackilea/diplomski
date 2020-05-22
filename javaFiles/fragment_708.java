//Please note - you will need to import java.util.Random;

        String[] randomMessages = new String[]{
                   "Message 1 (Change this)",
                   "Message 2",
                   "LOL",
                   "fdasfsd"
            };

        Random randomGenerator = new Random();
        int i = randomGenerator.nextInt(randomMessages.length);

        String s = randomMessages[i];

        int oldi = i;

        Random randomGenerator2 = new Random();
        i = randomGenerator2.nextInt(randomMessages.length);

        //Loop until we have a different index.
        while (i = oldi) {
             i = randomGenerator2.nextInt(randomMessages.length);
        }

        s = s + randomMessages[i];

        System.out.println(s);

        //Alternative suggestion from Richard Le Mesurier - using Collections.shuffle
        List list = Arrays.asList(randomMessages);
        Collections.shuffle(list);
        String s2 = list.get(0).toString() + list.get(1).toString();

        System.out.println(s2);