@Override
    public void actionPerformed(ActionEvent cb) 
    {
       GUI_Data.graphics = true;
       DrawGraph.getInstance().updateGraph();  // Calls Update Graph function
    }