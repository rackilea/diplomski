int x;
    for(int i=0; i<n_col; i++){ 
        // This time you declare a NEW array each time
        String[] current_columns = new String[rows];
        x=0;
        while(rs.next()){ 
            current = rs.getString(columns[i]);
            current_columns[x++] = current;
        }

        System.out.print("hm.put("+columns[i]+", {");
        for(int j=0; j<current_columns.length; j++)
            System.out.print(current_columns[j]+" ");
        System.out.println("});");

        hm.put(columns[i], current_columns);

        rs.beforeFirst();
    }