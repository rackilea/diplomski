public String submit() {
    if (confirm) {
        return outcome;
    } else {
        return "confirm";
    }
}