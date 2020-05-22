public static void hiMarkMethod(String[] NamePsd, int[] gradePsd)
    {

    String nameRtn = "";
    int num = gradePsd[0];

     System.out.println ("\n\nThe Student(s) with Hightest Mark(s) are:");
    //find the highest number
    for (int  i = 0; i < gradePsd.length;  i++){
    if (gradePsd[i] >= num){
        num = gradePsd[i];
    }
    //print students with that number
    for (int  j = 0; j < NamePsd.length;  j++){
        if (gradePsd[j] == num)
        {
            nameRtn = NamePsd[j]; 
            System.out.print(nameRtn + ", "); 
        }
    }