public void actionPerformed(ActionEvent e)
{
    Button b = (Button) e.getSource();

    if (b.getLabel().equals("Clear"))
    {
        tf.setText("");
    }
    else
    {
        tf.setText(tf.getText() + b.getLabel());
    }
}