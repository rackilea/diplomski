while (score != -1) {
        System.out.print("Enter the first test score:  ");
        score = scan.nextInt();
        if(score > 69)
        numberOfTestsPassed++;
        while (count != -1 && score > 0) {
            System.out.print("Enter the next test score:  ");
            score = scan.nextInt();
            count++;
            if (score == -1)
                break;
            else if (score > 69)
                numberOfTestsPassed++;
        }
         percentOfClassPassed = ((double)numberOfTestsPassed * 100 / count); 
    }