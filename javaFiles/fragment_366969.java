while (rset.next()) {
        a = new HashMap<Integer,Object>();
        a.put(1,rset.getInt(1));
        ..........
        list.add(a);
    }