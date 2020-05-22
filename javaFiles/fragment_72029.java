static class TestScreen extends MainScreen  {

    private static String down;

    public TestScreen () {
        HorizontalFieldManager hfm = new HorizontalFieldManager();
        add(hfm);
        hfm.add(new TestButton("bt1"));
        hfm.add(new TestButton("bt2"));
        hfm.add(new TestButton("bt3"));
        hfm.add(new TestButton("bt4"));
        hfm.add(new TestButton("bt5"));
        hfm.add(new TestButton("bt6"));
    }

    public static void touchDown(TestButton tb) {
        down = tb.getText();
        System.out.println("DOWN in " + tb.getText());
    }

    public static void touchUp(TestButton tb) {
        System.out.println("UP in " + tb.getText());
        if(!down.equals(tb.getText()))
            System.out.println("swap " + down + " and " + tb.getText());
        down = "";
    }




class TestButton extends LabelField {

    public TestButton (String label) {
        super(label);
    }

    protected boolean touchEvent(TouchEvent event) { 
        if(event.getEvent() == TouchEvent.UP)
            TestScreen.touchUp(this);
        else if(event.getEvent() == TouchEvent.DOWN)
            TestScreen.touchDown(this);
       return super.touchEvent(event);
    }


}

}