Random r=new Random();

char[] possibleChars="abc123!".toCharArray();
int length=5;

char[] newPassword=new char[length];

for (int i=0; i<length;i++)
    newPassword[i]=possibleChars[r.nextInt(possibleChars.length)];

System.out.println(new String(newPassword));