public class Mario {
    private upKey;

    public Mario(String upKey) {
         this.upKey = upKey;
    }

    public void jump(){
        if (Greenfoot.isKeyDown(upKey)){
            move(5);
        }
    }
}