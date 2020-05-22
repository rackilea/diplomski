Scanner sc;
char[] problem = null;
try {
    sc = new Scanner(new File("My file"));
    if (sc.hasNext()) {
        problem = sc.next().toCharArray();
    }
} catch (FileNotFoundException e) {
    e.printStackTrace();
}
System.out.println(Arrays.toString(problem));