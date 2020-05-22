Scanner scan = new Scanner(new File(yourPath));

int current = 0;
while(scan.hasNext()) {
    String next = scan.next();
    if(next.equals("null")) {
        continue;
    }
    System.out.print(next+" ");
    current++;
    if(current == 3) {
        System.out.println();
        current = 0;
    }
}