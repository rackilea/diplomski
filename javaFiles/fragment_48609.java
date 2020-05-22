for (SerialPort port : comPorts) {
    portsItems[q] = new MenuItem(port.getSystemPortName());
    int portNumber = q ; // effectively final
    portsItems[q].setOnAction(actionEvent -> {
        portNum = portNumber;
        connect.setDisable(false);
    });
    comPortsMenu.getItems().add(portsItems[q]);

    // increment:
    q++ ;
}