File file = new File("input.txt");
Scanner scan = new Scanner(file);

int size = Integer.parseInt(scan.nextLine());
String[] blocks = new String[size];

for (int i = 0; i < blocks.length; i++) {
    blocks[i] = scan.nextLine();
}

System.out.println(Arrays.toString(blocks));