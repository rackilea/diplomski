StringBuilder sb = new StringBuilder (dna.length());
for (char c : dna.toCharArray()) {
    if (c == 'A')
        sb.append('T');
    else if (c == 'T')
        sb.append('A');
    else if (c == 'G')
        sb.append('C');
    else if (c == 'C')
        sb.append('G');
} 
dna = sb.toString();