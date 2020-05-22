public static void main(String args[]) 
{

    String str = "RT @GHCheer2015: Freshman & Sophomores: Interested in cheer at GH? Email: jackemersoncheer@gmail.com";
      String punct = ",./;:'\"?<>[]{}|`~!@#$%^&*()";
      System.out.println(str);

      String[] punctArr = punct.split("");

         for(int i = 0; i < punctArr.length; i++){
             str = str.replace(punctArr[i], "");
         }

      System.out.println("Final string \n :" + str);
}