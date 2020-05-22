public MyFrame() {

       setTitle("example");
       setSize(300, 200);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);  
       JComboBox myBox=new JComboBox();
       ArrayList<CellRoomObject> cellRoomObjects =new ArrayList<CellRoomObject>();
        CellRoomObject c1=new CellRoomObject("Door" , 1 , true);
         CellRoomObject c2=new CellRoomObject("Oil lamp", 2 , true);
          CellRoomObject c3=new CellRoomObject("Chest" , 3 , true);
          cellRoomObjects.add(c1);
           cellRoomObjects.add(c2);
           cellRoomObjects.add(c3);
        DefaultComboBoxModel dcbm =new DefaultComboBoxModel(cellRoomObjects.toArray());
        myBox.setModel(dcbm);
        this.add(myBox);
        setVisible(true);
    }


    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyFrame ex = new MyFrame();
                ex.setVisible(true);
            }
        });
    }
}