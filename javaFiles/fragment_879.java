public class CheckArrayElementIsNull {

  public static void main(String[] args) {
     String[] arr = new String[3];       
     boolean flag=true; //use a flag that will check if null is encountered
     for(int i = 0; i < arr.length; i++) {
       if(arr[i] == null && flag) { // first time flag will be true
         arr[i] = "a"; 
         flag=false; //set flag to false , to avoid further assignment of 'a' to null values
        }
        System.out.println(i + "="+ arr[i]);    //print array
        }
     }
  }