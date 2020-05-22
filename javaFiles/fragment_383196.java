public static void main(String[] args) {
        int testNumber;
        String stuName;
        // TODO code application logic here
        System.out.println("How many tests were given?");
        Scanner input = new Scanner(System.in);
        testNumber = input.nextInt();

        System.out.println("Enter Student's Name");
        //Scanner nameInput = new Scanner(System.in); you don't have to use another scanner variable to read inputs only one is enough
        stuName = input.next();
        if (stuName.contains(" ")){
            System.out.println("This field should not contain spaces");


        }
        pointsPercent = pointsEarned(testNumber); // save the return value of pointsEarned method in pointsPrecent
        grade = letterGrade(pointsPercent); //save the return value of letterGrade method in grade 
        displayResult(stuName, pointsPercent, grade);
    }