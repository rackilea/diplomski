try (Scanner sc = new Scanner(new File("score.txt"))) {
  int score2 = sc.nextInt();
  System.out.println(score2);
} catch (IOException e) {
  e.printStackTrace();
}