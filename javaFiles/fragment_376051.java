private class ProgressBar<MyTypeVariable> extends JProgressBar 
implements TaskObject<MyTypeVariable> {

    @Override
    public void update(MyTypeVariable val) {
        System.out.println("pbar updating to " + val);
        setValue(val);
    }

}