int ch;
        JOptionPane.showMessageDialog (null, "1=+ 2=- 3=x 4=/ Please Choose Operation"); // Shows what numbers will do what operation when input
        ch = (int)JOptionPane.showInputDialog("Please Choose Operation").charAt(0); // Prompts user to input a number 1-4 for the operation they want to do
        switch (ch) {
            case 1:
                JOptionPane.showMessageDialog(null,"You Chose Additon"); // Adds up all ten integers from above
                JOptionPane.showMessageDialog(null, one + two + three + four + five + six + seven + eight + nine + ten);
                break;
            case 45:
                JOptionPane.showMessageDialog(null,"You Chose Subtraction"); // Subtracts all 10 numbers, resulting answer can be negative
                JOptionPane.showMessageDialog(null, one - two - three - four - five - six - seven - eight - nine - ten);
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "You Chose Multiplication Do not use zeroes");  // Multiplies all 10 integers, cannot use 0's since answer would be 0
                JOptionPane.showMessageDialog(null, one * two * three * four * five * six * seven * eight * nine * ten);
                break;
            case 4:
                JOptionPane.showMessageDialog(null,"You Chose Division Can't Divide by 0"); // Divdes all numbers, cannot use 0's because no dividing by 0
                JOptionPane.showMessageDialog(null, one / two / three / four / five / six / seven / eight / nine / ten);
                break;
            default:
                JOptionPane.showMessageDialog(null,"You have to choose an operation"); // If no operation is chosen, Program ceases and closes
                break;
    }