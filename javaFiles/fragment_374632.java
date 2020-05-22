Scanner scan = new Scanner(System.in);
while (scan.hasNextLine()) {
    String line = scan.nextLine();
    if ("quit".equalsIgnoreCase(line)) {
        break;
    }
    if (!line.isEmpty()) {
        String[] arr = line.toUpperCase().split("\\s+");
        char ch = arr[0].charAt(0);
        int val = Integer.parseInt(arr[arr.length - 1]);
        if (ch >= 'A' && ch <= 'Z') {
            map.put(ch, val);
        }
    }
}
System.out.println(map); // <-- output after getting all of the input