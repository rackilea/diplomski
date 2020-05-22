int numberPassed = 0; // counter to keep track of who passes
for (int score : d) {
    if (score >= 60) {
        numberPassed++; // pass score met so add one to counter
    }
}

System.out.println("Passed=" + numberPassed);