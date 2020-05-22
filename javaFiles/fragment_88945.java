for (int i= 0;i < cu.getCount();i++){
        cu.moveToPosition(i);

        r[0][i]=cu.getString(1);
        r[1][i]=cu.getString(2);
        r[2][i]=cu.getString(3);
    }
return r;