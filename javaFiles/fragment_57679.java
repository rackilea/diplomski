public void SetState(boolean bState) {
    if(this.bState == false && bState == true) {
        //Some other things to do
        getLogger().info('Inventory closed');
    }
    this.bState = bState;
}