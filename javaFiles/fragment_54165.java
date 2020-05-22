for(int i = 0; i < stuTable.getRowCount(); i++){
        Object seatNum = stuTable.getValueAt(i,0);
        int seatInt =  Integer.parseInt(String.valueOf(seatNum));
        for(int j = i + 1; j < stuTable.getRowCount(); j++){
            Object seatNum2 = stuTable.getValueAt(j,0);
            int seatInt2 =  Integer.parseInt(String.valueOf(seatNum2));
            if(seatInt == seatInt2){System.out.println(seatInt+":"+seatInt2);}
        }
}