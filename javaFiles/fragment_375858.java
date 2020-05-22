public static void classifyBMI (double bmi) {
    if(bmi < 18.5) {
        System.out.printf("Underweight");
    } else if (bmi >= 18.5 && bmi < 25) {
        System.out.printf("Normal Weight");
    } else if (bmi >= 25 && bmi < 30) {
        System.out.printf("Overweight");
    } else {
        System.out.printf("Obese");
    }
}