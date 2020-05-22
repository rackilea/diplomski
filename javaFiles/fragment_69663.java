public void checkBottomCollision() {
    blocks = game.getEntityManager().getBlocks();
    for (int i = 0; i < blocks.size(); i++) { 
        Block tempBlock = blocks.get(i);
            if(this.getBottomBounds().intersects(tempBlock.getBounds())){
                this.y = tempBlock.getY() + this.height;
            }
        }
    }
}