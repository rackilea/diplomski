if (combatLog.contains("*name*")) { // don't escape in contains()
    combatLog = combatLog.replaceAll("\\*name\\*", replacement);// correct escape
}
// another regex based solution
if (combatLog.contains("*name*")) {
    combatLog = combatLog.replaceAll("[*]name[*]", replacement);// character class
}