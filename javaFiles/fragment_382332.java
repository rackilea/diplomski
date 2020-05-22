public void actionPerformed(ActionEvent arg0) {

        Timer timer = new Timer(1000, new ActionListener() {
             private int iteration;
             @Override
             public void adtionPerformed(ActionEvent evt) {

                try {

                    String testSpring = null;
                    String tVarString = null;

                    testSpring = inputExpression;
                    tVarString = String.valueOf(iteration);
                    testSpring = testSpring.replaceAll("t", tVarString);

                    Equation equation = new Equation(testSpring);

                    graph.addEquation(equation);

                 } catch (EquationSyntaxException e) {
                    e.printStackTrace();
                } finally {
                     iteration++
                     if (iteration > 4) {
                         ((Timer)evt.getSource()).stop();
                     }
                }
            }
        });
        timer.start();

    }
});