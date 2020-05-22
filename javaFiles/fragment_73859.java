public static void main(String args[])
    {
        String time = "10:07"; //User Input
        time = time.replace(":", "");
        char digit[] = {time.charAt(0), time.charAt(1), time.charAt(2), time.charAt(3)};
        int[] count = new int[digit.length];
        Arrays.sort(digit);

        for (int i = 0; i < digit.length; i++)
        {
            count[i]++;
            if (i + 1 < digit.length)
            {
                if (digit[i] == digit[i + 1])
                {
                    count[i]++;
                    i++;
                }
            }
        }

        for (int i = 0; i < digit.length; i++)
        {
            if (count[i] > 0)
            {
                System.out.println(digit[i] + " appears " + count[i]+" time(s)");
            }
        }
    }