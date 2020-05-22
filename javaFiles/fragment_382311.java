/* Junction method states if there is more than one passage, it will randomly select one.
    If there is no passage, it will randomly select a nonwall/BeenBefore direction. */
public int junction(IRobot robot) {

    if (passageExits(robot) >= 1) {
        int randomPassage = ((Math.random())*(passageDirections.length()));
        passageDirections.get(randomPassage);
    } else {
        int randomNonwall = ((Math.random())*(nonwallDirections.length()));
        nonwallDirections.get(randomNonwall);
    }
}