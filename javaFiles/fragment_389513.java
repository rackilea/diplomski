if(b1.getText().equals("Click For Answer"))
            {
                problems.run();
                jl.setText(problems.toString()); // note the change here
                String b = "Next Question";
                b1.setText(b);
            }
            else
            {
                problems.run();
                jl.setText(problems.getQuestion()); // and how you got it right here
                String b = "Click For Answer";
                b1.setText(b);

            }