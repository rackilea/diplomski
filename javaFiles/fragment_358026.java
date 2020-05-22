@Override
public void keyPressed(KeyEvent e){

    int key = e.getKeyCode();

    for(int i = 0;(i< handler.object.size()); i ++){

        GameObject tempObject = handler.object.get(i);

        if(tempObject.getId() == ID.player){

            if(key == KeyEvent.VK_W){ 
                tempObject.setvelY(-5);
            }

        }
    }

}

@Override
public void keyReleased(KeyEvent e){

    int key = e.getKeyCode();

}