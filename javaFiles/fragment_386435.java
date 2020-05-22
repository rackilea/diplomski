private void build(Stadium stadium)
{  

   ActionListener listener = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            //Here you implement what you want your listener to execute on  button click;
        }
    };

   add(button("Front", listener));
   add(button("Middle", listener));
   add(button("Back", listener));

}

private JRadioButton button(String label, Listener listener)
{   JRadioButton button = new JRadioButton(label);
    button.addActionListener(listener);
    group.add(button);
    return button;  }