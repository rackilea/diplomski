public class MyString {
    String text;

    public MyString(String text){
        this.text = text;
    }

    public String subString (int start){
        int thisStart = start;
        char [] textArray = text.toCharArray();
        int newCharSize = text.length - start;

        char [] newData=new char[newCharSize];

        for(int c=0;c<newData.length;c++){
            newData[c]=textArray[thisStart];
            thisStart++;
        }

        return newData.toString() ;
   }

   @Override
   public String toString(){
       return text;
   }
}