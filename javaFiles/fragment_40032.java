String CurChoice = "";
boolean isCorrectCurrency = false;
do {
    CurChoice = keybStr.next();
    isCorrectCurrency = CurChoice.matches("^EUR|USD|JPY|PLN$");
    if (isCorrectCurrency) {
        System.out.println("Hey It matched to proper currency");
    } else {
        System.out.println("Hey It didn't matched to proper currency. Please retry");
    }
} while (!isCorrectCurrency);