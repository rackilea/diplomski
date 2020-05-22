public static void sort(HighScores[] scores)
    {
        for(int i = 0; i < scores.length; i++)
        {
            int smallest = i;

            for (int j = i; j < scores.length; j++)
            {
                if (scores[j].getScore() < scores[smallest].getScore())
                    smallest = j;
            }

            HighScores temp = scores[i];
            HighScores swap = scores[smallest]; //This is where I'm getting the out of bounds exception.
            scores[i] = swap;
            scores[smallest] = temp;

        }
    }