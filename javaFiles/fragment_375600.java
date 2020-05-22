boolean isFirstIteraton = true;
boolean targetExceptionWasThrown = false;
do {
    try {
        //Stuff
    } catch() {
        if (! isFirstIteraton) {
            targetExceptionWasThrown = true;
        }
    }
    isFirstIteraton = false;
} while (! targetExceptionWasThrown);