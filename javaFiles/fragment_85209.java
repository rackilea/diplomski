outputStrings.add(" "); // this is ignored, but cannot be empty
switch (word) {
    case "<FIGHTER>":
        outputStyles.add("fighterIcon");
        break;
    case "<CLERIC>":
        outputStyles.add("clericIcon");
        break;
    case "<WIZARD>":
        outputStyles.add("wizardIcon");
        break;
    case "<ROGUE>":
        outputStyles.add("rogueIcon");
        break;
}
outputStrings.add(" "); // this is ignored, but cannot be empty
outputStyles.add("regular");