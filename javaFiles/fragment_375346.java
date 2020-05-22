class YOurClassName{

private String query; //make here.....<<<<<<<<

public void run() {

(...)
start.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e)
    {
if(firstSel==null || selchose.getText().equals(selchose_str) || selbase.getText().equals(base_str)) {
            query = "Select * FROM EMP";
        }
(...)


}