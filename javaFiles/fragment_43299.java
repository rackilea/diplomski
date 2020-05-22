public void initKeyActions(Scene scene){
    scene.setOnKeyPressed(keyAction ->{
        System.out.println(keyAction.getCode());
        if(keyAction.getCode()==KeyCode.DIGIT1)
            one.fire();//Fires the necessary button
        else if(keyAction.getCode()==KeyCode.DIGIT2)
            two.fire();
        //Continue as I don't want to type these all out
    });
}