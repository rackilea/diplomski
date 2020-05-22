@Override
public void resize(int Width, int Height) {
        Width = VIRTUAL_WIDTH;  
        Height = VIRTUAL_HEIGHT; 

        stage.getViewport().update(Width, Height, true); 
}