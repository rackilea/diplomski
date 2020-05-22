panel_Letzte24H.addChartMouseListener((new ChartMouseListener() {
    public void chartMouseClicked(ChartMouseEvent mE) {
        System.out.println(mE.getEntity());
        String full = mE.getEntity().toString();
        String[] firstSplit = full.split("item = ");
        String[] finalSplit= firstSplit[1].split(",");
        try{
            int index;
            index = Integer.parseInt(finalSplit[0]);
            System.out.println("Indexnumber: " + index);
        }
        catch(NullPointerException e){}
    }

    public void chartMouseMoved(ChartMouseEvent arg0) {
        // nothing here
    }
}));