public String toString() {
    return String.format( "Your selection: %s: \nYour amount due: %.2f \nYour change: %.2f",
        selection,
        amountDue,
        change);
}