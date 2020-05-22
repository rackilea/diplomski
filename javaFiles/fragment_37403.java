while ( grade != -1 ) {

        sumGrade += grade;
        count++;
        System.out.print("Grade: ");

        grade = input.nextDouble();

        if(grade < minGrade && grade != -1)
            minGrade = grade;

    } 

    sumGrade = sumGrade - minGrade;
    count = count - 1;
    average = (sumGrade / count);
    System.out.print("Your average is: " +average);