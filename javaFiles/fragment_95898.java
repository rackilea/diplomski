class ScratchPaper {
    String text = "A";
    String getText(){
        return text;
    }
    public static void main(String[] args) {
        System.out.println((new B()).getBText());
    }
}
class B extends ScratchPaper {
     B(){
         text = getText() + "C";
     }
     String getBText(){
         return  "D" + super.getText();
     }
}