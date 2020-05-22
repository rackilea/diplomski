/**
 * method to search for active internal frame windows
 * and return true or false depending on the outcome. this method uses internalframe names
 */
public boolean searchIFrame(String search, JInternalFrame frame[])
{
    for(int i = 0; i < frame.length; i++)
        if(frame[i].getTitle().toString().equals(search))
            return true;
        return false;
}

//its implementation in your program. "Information Form" is the internalframe's name
//jdesk is the desktoppane object or instance
boolean srch = searchIFrame("Information Form", jdesk.getAllFrames());
    if(!srch) {        
                VisitationForm at = new VisitationForm();
                at.pack();
                jdesk.add(at);

                try
                {
                    at.setSelected(true);
                    at.setVisible(true);
                    // We're done, so clear the feedback message
                    //bar.setString(" ");
                    //bar.setIndeterminate(false);
                    at.requestFocus();

                }
                catch (PropertyVetoException pve)
                {
                    //bar.setString(" ");
                    //bar.setIndeterminate(false);

                    // Then display the error in a dialog box
                    System.out.println(pve);
                }

            }