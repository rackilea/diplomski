public void RemoveRow(int rowIndex) {
    UserInformation temp = Udata.get(rowIndex);//Keep it as back up so that you could reconsolidate it to ArrayList in case RemoveUserFromFile return false
    Udata.remove(rowIndex);//remove the element from Udata on temporary basis.
    if (RemoveUserFromFile(rowIndex)) 
    {
          fireTableRowsDeleted(rowIndex, rowIndex);
    } 
    else 
    {
        Udata.add(rowIndex,temp);//re-insert temp in ArrayList as the file updation is failed.
        JOptionPane.showMessageDialog(null, "Unable to delete");
    }
}

public boolean RemoveUserFromFile(int index) 
{
    File Mf = new File("AllUserRecords.txt");
    File Tf = new File("Uoutput.txt");
    PrintWriter Upw = null;
    try 
    {
        Upw = new PrintWriter(new FileWriter(Tf));
        for (UserInformation uino : Udata )
        {
            Upw.print(uino.toString());//Don't use Upw.println because the toString() method of UserInformation class is already using \n in last.
        }
        Upw.close();
        Mf.delete();
        Tf.renameTo(Mf);
        return true;
    } catch (FileNotFoundException e1) {
        return false;
    } catch (IOException ioe) {
        return false;
    }
    finally 
    {
        if (Upw != null)
        {
            try
            {
                Upw.close();
            }
            catch (Exception ex){}
        }
    }
}