public void run() {

    String output = num + " is" + (IsPrime(num) ? " " : " not ")
            + "a prime number.";
    lblResults.setText(output);

    String output2 = num2 + " is" + (IsPrime(num2) ? " " : " not ")
            + "a prime number.";
    lblResults2.setText(output2);
}}