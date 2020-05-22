int size = 10;
int count = 0;

int[] yourNumbers = new int[size];

do {
    yourNumbers[count] = Integer.parseInt(JOptionPane.showInputDialog(null,
        "Your message here."));

    count++;
} while (count < 10);