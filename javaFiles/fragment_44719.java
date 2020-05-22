private void fullRotate(int selectionIndex, int direction)
       throws InterruptedException{
    for(int i = 0; i < 9; ++i){
        glc.rotMultipleCubeSlow(selectionIndex, direction);
        Thread.yield();
    }
    glc.setMovesText(selectionIndex, direction);        
    glc.setMultipleStateAndColorsByTable(selectionIndex, direction);
    glc.isEntitiesRight();
}