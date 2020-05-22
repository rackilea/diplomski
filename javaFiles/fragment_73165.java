public void copyToCacheSlot(int[] mainMem, int baseIndex, int length){
    if (length <= 8)
        System.arraycopy(mainMem, baseIndex, this.dataBlock, 0, length);
    else
        //Copied too much 
}