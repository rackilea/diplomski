StringBuilder sb = new StringBuilder();
    for (String str : firstString) {
        if (!str.equalsIgnoreCase("end")) {
            sb.append(str);
            sb.append(" ");
        } else {
            sb.deleteCharAt(sb.lastIndexOf(" "));
        }
    }
    System.out.println(sb.toString());