if(Keyboard.getEventKey() == Keyboard.KEY_RIGHT) {
        if(Keyboard.getEventKeyState()){
            System.out.println("KEY DOWN!");
            flag = true;       
        }
        else{
            System.out.println("KEY RELEASED!");
            flag = false;
        }
    }
}

//player movement code

if(flag) {
    player.playerMovingRight();
}