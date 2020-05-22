class MyButton extends JButton
{
    private int numOfClicks;    //Add additional property for JButton

    public MyButton(String name){
        super(name);
        numOfClicks = 0;        
    }

    public int getClicks(){
        return numOfClicks;
    }

    public void setClicks(int clicks){
        this.numOfClicks = clicks;
    }    
}