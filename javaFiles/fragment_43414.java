String input[] = request.getParameterValues("checkbox");

    StringBuilder sb = new StringBuilder(); // create empty StringBuilder instance
    for(int i=0;i<input.length;i++) {
        sb.append(input[i]);     //append element
        if (i==input.length-1) {
            sb.append(" ");      //append space
        } else {
            sb.append(", ");     //append comma
        }
    }

    String result = sb.toString();
    Systemout.println(result);