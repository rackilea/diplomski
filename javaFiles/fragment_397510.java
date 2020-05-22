if (e.getKeyCode() == KeyEvent.VK_UP) 
{
    index = (index + 1)% history.list.size();  //Ensure it stays within bounds
    field.setText(history.list.get(index));
}
else if (e.getKeyCode() == KeyEvent.VK_DOWN) 
{
    index = Math.max(0, index - 1);            //Ensure it stays within bounds
    field.setText(history.list.get(index));
}