ITickRenderer r = new ITickRenderer(){
    @Override
    public String format(float arg0) {
        return m.df.format(arg0);
    }
};