public Test() {
    initComponents();
    try {
        ip = InetAddress.getLocalHost();
        name.setText(ip.getHostName());
    } catch (Exception e) {
    }
} //