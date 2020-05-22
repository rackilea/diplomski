b1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            if(b1.getText().equals("Click For Answer")
            {
                String b = "Next Question";
                b1.setText(b);
                jl.setText(expected.toString());
            }
            else
            {
                String b = "Click For Answer";
                b1.setText(b);
                jl.setText(question.toString());
            }
      }
});