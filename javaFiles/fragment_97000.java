public static void main(String[] args) throws IOException {
        String polynomial = "3x^4+5x^45-2+77x^100";
        int lastNumber = 0;
        int temp = 0;
        String output = "";
        for(int i = 0; i < polynomial.length() - 1; i++)
        {
            if(polynomial.charAt(i) == 'x')
            {
                int counter = i + 1;
                int a = 0;
                int b = 0;
                String tempString1 = "";
                String tempString2 = "";
                String number = "";
                while((polynomial.charAt(counter) != '0') && (polynomial.charAt(counter) != '1') && (polynomial.charAt(counter) != '2') && (polynomial.charAt(counter) != '3') && (polynomial.charAt(counter) != '4') && (polynomial.charAt(counter) != '5') && (polynomial.charAt(counter) != '6') && (polynomial.charAt(counter) != '7') && (polynomial.charAt(counter) != '8') && (polynomial.charAt(counter) != '9'))
                {
                    tempString1 += polynomial.charAt(counter);
                    counter++;
                }
                while((counter < polynomial.length()) && ((polynomial.charAt(counter) == '0') || (polynomial.charAt(counter) == '1') || (polynomial.charAt(counter) == '2') || (polynomial.charAt(counter) == '3') || (polynomial.charAt(counter) == '4') || (polynomial.charAt(counter) == '5') || (polynomial.charAt(counter) == '6') || (polynomial.charAt(counter) == '7') || (polynomial.charAt(counter) == '8') || (polynomial.charAt(counter) == '9')))
                {
                    number += polynomial.charAt(counter);
                    counter++;
                }
                a = Integer.parseInt(number);
                temp = counter - 1;
                counter = i - 1;
                number = "";
                while((polynomial.charAt(counter) != '0') && (polynomial.charAt(counter) != '1') && (polynomial.charAt(counter) != '2') && (polynomial.charAt(counter) != '3') && (polynomial.charAt(counter) != '4') && (polynomial.charAt(counter) != '5') && (polynomial.charAt(counter) != '6') && (polynomial.charAt(counter) != '7') && (polynomial.charAt(counter) != '8') && (polynomial.charAt(counter) != '9'))
                {
                    tempString2 = polynomial.charAt(counter) + tempString2;
                    counter--;
                }
                while((counter >= 0) && ((polynomial.charAt(counter) == '0') || (polynomial.charAt(counter) == '1') || (polynomial.charAt(counter) == '2') || (polynomial.charAt(counter) == '3') || (polynomial.charAt(counter) == '4') || (polynomial.charAt(counter) == '5') || (polynomial.charAt(counter) == '6') || (polynomial.charAt(counter) == '7') || (polynomial.charAt(counter) == '8') || (polynomial.charAt(counter) == '9')))
                {
                    number = polynomial.charAt(counter) + number;
                    counter--;
                }
                b = Integer.parseInt(number);
                for(int j = lastNumber; j <= counter; j++)
                {
                    output += polynomial.charAt(j);
                }
                output += "" + (a * b) + "x^" + (a - 1);
                lastNumber = temp + 1;
                i = temp;
            }
        }
        System.out.println(output);
    }