public Vector sort(Vector sort) {
        Vector v = new Vector();
        for(int count = 0; count < e.length; count++) {
            String s = sort.elementAt(count).toString();
            int i = 0;
            for (i = 0; i < v.size(); i++) {
                int c = s.compareTo((String) v.elementAt(i));
                if (c < 0) {
                    v.insertElementAt(s, i);
                    break;
                } else if (c == 0) {
                    break;
                }
            }
            if (i >= v.size()) {
                v.addElement(s);
            }
        }
        return v;
    }