boolean correct = true;
do {
    System.out.print("Grade (9-12): ");
    userGrade = keyboard.nextInt();
    if (userGrade < 9 || userGrade > 12) {
        correct = false;
        System.out.println("message saying you're wrong");
    } else {
        correct = true;
    }
} while (!correct);