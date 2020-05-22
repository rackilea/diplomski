private class RightClickNodeAction extends AbstractAction{      
    RightClickNodeAction(String name){super(name);
    putValue(ACTION_COMMAND_KEY, name); 
    }//end constructor
public void actionPerformed(ActionEvent ae) {
   //System.out.println("Action Command is: "+ae.getActionCommand());
   //the above comment verified it worked as expected + testing
if(ae.getActionCommand().equals("Add SiblingNode"))addSiblingNode();
if(ae.getActionCommand().equals("Add ChildNode"))addChildNode();     }}