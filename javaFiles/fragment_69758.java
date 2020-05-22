public static void gradeMessage(String result) {
    // Compute if grade leads to pass or fail

    if (result == "F") {
        System.out.println("Unfortunately, you have a Grade F, so you have failed this exam");
    }

    else {
        System.out.println("Congratulations, you are awarded a Grade" + result + " Pass");
    }
}