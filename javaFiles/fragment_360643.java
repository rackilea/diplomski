public static void main(String[] args)
    {
        String [] grades = {"AAAB","ABAA","AABA"};  
        System.out.println(countOccurences(grades[0], 'A'));
    }

    public static int countOccurences(String grades, char gradeToMatch )
    {
        int count = 0;
        for(char grade : grades.toCharArray())
        {
            if(grade == gradeToMatch)
              ++count;
        }
        return count;
    }