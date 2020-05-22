private final IntSet pressedButtons = new IntSet(5); 
// There are five possible buttons (See com.badlogic.gdx.Input.Buttons)

void updatePressedButtons (){
    pressedButtons.clear();
    for (int i=0; i<5; i++){
        if (Gdx.input.isButtonPressed(i)) pressedButtons.add(i);
}