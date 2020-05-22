public class Test{

 public static void main(String[] args) {
    Test test=new Test();
    String result1=test.runCommand(test::stringCommand);
    Integer result2=test.runCommand(test::integerCommand);
    Boolean result3 = inter.runCommand(new MyCommand<Boolean>() {
        @Override
        public Boolean execute() {
            return true;
        }
    });
 }

 public String stringCommand() {
    return "A string command";
 }

 public Integer integerCommand() {
    return new Integer(5);
 }

 public <T>T runCommand(MyCommand<T> command){
    return command.execute();
 }
}