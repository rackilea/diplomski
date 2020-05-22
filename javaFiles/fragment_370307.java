import java.util.Scanner;

    public class TextBox {
        public static void main(String[] args) {
            String inputString;
            char character;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the text: ");
            inputString=sc.nextLine();
            System.out.println("Enter the character : ");
            character = sc.next().charAt(0);
            sc.close();
            drawTextbox(character,inputString);
        }
        public static void drawTextbox (char character, String inputString){
            int width=inputString.length()+6;
            for(int i=0;i<width;i++){
                System.out.print(character);    
            }
            System.out.println();
            for(int i=0;i<width;i++){

                if(i==0||i==width-1){
                    System.out.print(character);
                }
                else if(i>2&&i<width-3){
                    System.out.print(inputString.charAt(i-3));
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
            for(int i=0;i<width;i++){
                System.out.print(character);

            }
        }

    }