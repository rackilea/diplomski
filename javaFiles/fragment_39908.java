for (int i = 1; i < counts.length; i++){    
    StringBuilder sb = new StringBuilder(20);
    sb.append(i);
    sb.append(" letter words: ");
    for (int j = 1; j <= counts[i]; j++) {
        sb.append('*');               
    }
    System.out.println(sb);
}