String networkType;

grid_rb.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent arg0) {
        setNetworkType("--grid-net");
    }
});

public void getNetworkType() {
    return networkType;
}
public void setNetworkType(String nwt) {
    networkType = nwt;
}