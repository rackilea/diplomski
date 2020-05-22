private String getColor(int num) {
    switch (num) {
        case 1: return "red";
        case 2: return "blue";
        case 3: return "green";
        default: return "";
    }
}

for (int i = 0 ; i < V ; ++i) {
    System.out.print(getColor(value[i]) +" ");
}
System.out.println();