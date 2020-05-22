String nickname = "myAwesomeNickname";

try {
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("c:/nicknames.txt", true)));
    out.println(nickname);
    out.close();
} catch (IOException e) {
    //exception handling 
}