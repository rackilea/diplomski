@Override
public void actionPerformed(ActionEvent e)
{

    for(int i = 0; i < word.length(); ++i)

        if(word.charAt(i) == 't')//if this condition is true
        {                  //that means the character is at the position `i`
            switch (i)
            {
                case 1:
                    lblSpace1.setText("T");
                    break;
                case 2:
                    // do other stuff
                    break;
                default:
                    break;
            }
        }
}