public void onCheckedChanged(RadioGroup group, int checkedId) {

    if (group.findViewById(checkedId).isPressed()) {
       //This will only execute if pressed. not if device rotates
    }

}