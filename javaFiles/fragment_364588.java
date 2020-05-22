b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(b1.getText().equals("Click For Answer"))
                {
                    problems.run();
                    jl.setText(problems.toString());
                    b = "Next Question";
                    b1.setText(b);
                }
                else
                {
                    problems.run();
                    jl.setText(problems.getQuestion());
                    b = "Click For Answer";
                    b1.setText(b);

                }
            }
        });