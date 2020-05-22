public int getSum(){
        int sum=0;

        for(int i=0; i < sqlite_master.getRowCount(); i++)
        {
            sum=sum+Integer.parseInt((String) sqlite_master.getValueAt(i, 2));      
        }
        return sum;
    }