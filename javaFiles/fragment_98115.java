public void methodOne(Integer argument)  {
     methodTwo(argument);
} 

public void methodTwo(Object argument) {
     System.out.println(((Date) argument).getTime());
}