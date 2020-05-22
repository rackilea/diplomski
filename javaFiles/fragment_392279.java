try (Scanner scan = new Scanner(file)) {
    while (scan.hasNext()) {
        String next = scan.next()
        for(int i = 0; i<arr.length; i++){
            if (next.equals(arr[i])){
              wordCount++;
            }
        }
    }
}