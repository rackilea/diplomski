boolean ok = false;
try {
    int guess = Integer.parseInt(mGuess);
    ok = guess >= 1 && guess <= 10;
} catch (NumberFormatException ignored) {
}
if (!ok) { . . .