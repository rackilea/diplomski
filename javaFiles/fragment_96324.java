if (command.equalsIgnoreCase("move")) {
    try {
       move1 = Integer.parseInt(splitUpText[1]);
       move2 = Integer.parseInt(splitUpText[2]);
       g.moveTo(move1, move2);
    } catch (ArrayIndexOutOfBoundsException e1) {
       Sytem.out.println("Please specify 2 parameters!")
       continue;
    } catch (NumberFormatException e2) {
       Sytem.out.println("Invalid parameters!")
       continue;
    }
}