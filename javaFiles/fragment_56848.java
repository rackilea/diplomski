public int getBirthYear() {
    boolean prompt = true;
    while (prompt) {
        String enteredAge = showInputDialog(null,"Enter age:");
        if (enteredAge == null) { // Cancel pressed
            age = -1;
            prompt = false;
        } else {
            try {
                age = Integer.parseInt(enteredAge);
                age = year - age;
                prompt = false;
                showMessageDialog(null, age);
            } catch (NumberFormatException e) {
                showMessageDialog(null, "Enter a valid number");
            }
        }
    }
    return age;
}