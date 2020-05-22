public class Test33 {

        public static void main(String[] args) {

            String russianAlphabet = " абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
            String text = "с точки зрения банальной эрудиции, каждый индивидуум вышедший из сферы эмбрионального развития " +
                    "не способен патологически идеализировать метаморфические абстракции";

            for(int i = 0; i < text.length(); i++){
                System.out.print(String.format("%3c | ",text.charAt(i)));
            }
            System.out.println();

            for(int i = 0; i < text.length(); i++){
                System.out.print(String.format("%3d | ",russianAlphabet.indexOf(text.charAt(i))));
            }

            System.out.println();

        }

    }