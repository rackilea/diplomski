void set() // rework with array
{
try {
    //sets the question label
    jb[4].setSelected(true);

    if (current < questions.length) {
        label.setText("Question " + (current + 1) + ": " + questions[current]);

        int j = current*4;
        for (int k = 0; k < 4; k++) {

                jb[k].setText(answers[j+k]);

            }
        }
    }

    for (int i = 0, j = 0; i <= 90; i += 30, j++) {
        jb[j].setBounds(50, 80 + i, 600, 20);
    }

} catch (NullPointerException ex) {
    System.out.println("Error at: " + count + ex.getMessage()); //testing what's going on
}
}