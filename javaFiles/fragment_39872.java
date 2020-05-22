switch (sign) {
    case "+":
        output.setText(tempDouble + tempDouble2);
        break;

    case "-":
        output.setText(tempDouble - tempDouble2);
        break

    case "X":
        output.setText(tempDouble * tempDouble2);

    case "/":
        if (tempDouble2 = 0) {
            //Cannot devide by zero
            output.setText("X");
        } else {
            output.setText(tempDouble / tempDouble2);
        }
}