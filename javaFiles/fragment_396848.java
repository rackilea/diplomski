// Run method of TimerTask
public void run() {
    if (!answered) {
        System.out.println("Time exceeded");
        timeExceed = true;
    }
}


// Main thread

// Print the question
startTimer(); // Use Timer and TimerTask

guess = input.next();
if (timeExceed) {
    System.out.println("Time exceeded your answer is not accepted");
} else {
    answered = true;
    // Handle answer
}