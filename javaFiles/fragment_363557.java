JOptionPane.showMessageDialog(null, 
        "Results" + 
        "\n The circumference of the circle is: " + formatter.format(2*Math.PI*radius) + " Centimeters" +
        "\n The diameter of the circle is: " + 2*radius + " Centimeters" +
        "\n The area of the circle is: " + formatter.format(Math.PI*Math.pow(radius,2)) + " Centimeters", 
        "Results", 
        JOptionPane.INFORMATION_MESSAGE);