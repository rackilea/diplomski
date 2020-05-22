if (shape.equalsIgnoreCase("circle")) {
                    shape = c;
                    circleInput = JOptionPane.showInputDialog ("Enter the radius.");
                    radius = Math.abs(Integer.parseInt(circleInput));
                    circleInput.setRadius(radius); //DO THIS                        

                    JOptionPane.showMessageDialog ( 
                    null, "The area of the circle is " + circleSolution.getCircleArea(), "Results", 
                    JOptionPane.PLAIN_MESSAGE);