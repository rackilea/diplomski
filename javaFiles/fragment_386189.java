// check if all three numbers match, if this is true the else-if is skipped
if (slot1 == slot2 && slot2 == slot3) {
    System.out.println("Jackpot!");

// check if two numbers match
} else if (slot1 == slot2 || slot2 == slot3 || slot1 == slot3) {
    System.out.println("Matched 2!");
}