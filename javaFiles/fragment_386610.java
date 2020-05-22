btnar = new ArrayList<>();

for (int i=0; i < filelist1.length; i++) {
        downloadbtn = new Button("Download");
        btnar.add(downloadbtn);
        final int index=i;
        downloadbtn.setId(String.valueOf(index));
        downloadbtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                try {
                    System.out.println("sssss");                             
                    System.out.println(filelist1[index].getName());   

                } catch (Exception ex) {
                    Logger.getLogger(HomeUI_2Controller.class.getName()).log(Level.SEVERE, null, ex);
                }


            }
        });
    }