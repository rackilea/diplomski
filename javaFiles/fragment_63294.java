StringBuilder consoleString = new StringBuilder();
// I'm using a StringBuilder here to avoid creating a lot of `String` objects
for(String element : BattleConsole) {
    // I'm assuming element is not null
    if(!"".equals(element)) {
        consoleString.append(element);
        consoleString.append(System.getProperty("line.separator")); // I'm using a constant here.
    }
}
update.setText(consoleString.toString());