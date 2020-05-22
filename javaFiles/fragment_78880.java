String result = "(";
    for (int i = 0; i < list.size(); i++) {
        if (i != 0) {
            result += ",";
        }
        result += "'" + list.get(i) + "'";
    }
    result += ")";
    System.out.println(result);