String inputStr = "";
            double num2process = 0.0;
            double sum = 0.0, ave = 0.0;

            double[] grade ;          //Just Make an Instance of it

            while(true)
            {
                try
                {
                    inputStr = JOptionPane.showInputDialog("Enter number of subjects to enter: ");
                    num2process = Double.parseDouble(inputStr);
                    grade = new double[(int) num2process];     //Initialize it Here
                    while(ctr<num2process)
                    {
                        grade[ctr]= getNumber();
                        sum += grade[ctr];
                        ctr++; 
                    }

                }
                catch(Exception e){
                    //Your Exception Handling
                }
            }