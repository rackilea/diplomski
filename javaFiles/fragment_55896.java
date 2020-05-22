public static void main(String[] args){

    String[] str ={"sup","aisu", "sup","aisu","sandy","sandu","vijay","gani","sup","sup","gani","sandu"};
    String[] alreadyValidated = new String[str.length];
      int i=0,j=0,count=0;
      System.out.println("The array size is"+str.length);
      System.out.println("The array elements are");
      for( i=0;i<str.length;i++)
                for(j=0;j<str.length;j++)
      {
            boolean skipCheck = false;
            for (String string : alreadyValidated) {
                if(str[i] == string) {
                    skipCheck = true;
                    break;
                }
            }
            if(!skipCheck) {
                System.out.println("Checking for word..."+str[i]);
                for(j=1;j<str.length-1;j++)
                {
                     if(str[i]==str[j])
                     {
                         count++;
                      }
                }
                System.out.println("The count is ..."+count+ " for word..."+str[i]);
                count = 0;
                alreadyValidated[i] = str[i];
            }
       }

}