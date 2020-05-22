private class ProgressBar extends JProgressBar 
implements TaskObject<Integer> {

    @Override
    public void update(Integer val) {
        System.out.println("pbar updating to " + val);
        setValue(val);
    }

}