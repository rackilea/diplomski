for (int i = 0; i < states.length; i++) {
    // locally scoped to the for loop 
    StringBuilder sb = new StringBuilder();
    for (int j = 0; j < states[i].length; j++) {
        sb.append(states[i][j]);
    }
    System.out.println(sb); // will work here 
}

System.out.println(sb); // but not here