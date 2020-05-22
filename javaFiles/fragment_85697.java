buttonSubmit = new JButton(new AbstractAction("Submit"){

    public void actionPerformed(ActionEvent e){
        try {
            check((int)(engine.eval(expression)));
        } catch (ScriptException e1) {
        }

        buttonNext.setEnabled(true);
        buttonSubmit.setEnabled(false);

    }

});

buttonNext = new JButton(new AbstractAction("Next Question"){

    public void actionPerformed(ActionEvent e){
        setQuestionArithmetic();
        answer.setText("");
        correct.setText("");

        buttonSubmit.setEnabled(true);
        buttonNext.setEnabled(false);
    }
});

buttonNext.setEnabled(false);