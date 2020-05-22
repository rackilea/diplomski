for(int i = 0; i < 10; i++) {
        Label data1 = new Label(1, i, "1");
        wsheet.addCell(data1);
        Label data2 = new Label(2, i, "2");
        wsheet.addCell(data2);
        Label data3 = new Label(3, i, "3");
        wsheet.addCell(data3);
   }
   wworkbook.write();   
   wworkbook.close();