StringBuilder sb = new StringBuilder();
for (int i = 0; i < states.length; i++) {
    for (int j = 0; j < states[i].length; j++) {
        sb.append(states[i][j]);
    }
    System.out.println(sb); // will still work here 
}

System.out.println(sb); // and now works here