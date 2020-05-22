try { 
    FileWriter writer = new FileWriter("count.txt");
    System.out.println(new Date());
    int number = 1000000000;
    do {
        writer.write(number + "\n");
    } while (number++ < 2000000000);
    System.out.println(new Date());
    writer.close(); 
} catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}