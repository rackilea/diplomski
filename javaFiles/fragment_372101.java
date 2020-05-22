if (buttonType.equalsIgnoreCase("right")) {

    this.rightButtons[num] = createButton("Is this the correct one?",40,40,Color.LIGHT_GRAY);
    this.add(this.rightButtons[num]);                   
} else if (buttonType.equalsIgnoreCase("wrong")) {
    this.wrongButtons[num] = createButton("Is this the correct one?",40,40,Color.LIGHT_GRAY);
    this.add(this.wrongButtons[num]);
}