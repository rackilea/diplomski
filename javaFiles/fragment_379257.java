StringBuilder sentence=new StringBuilder();
do {
    word = in.nextLine();
    count++;   
    System.out.print(" "+word);
    sentence.append(" "+word);
}
while (!word.equals(SENTINEL));