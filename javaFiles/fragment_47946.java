@Override
public String getValueAt(int rowIndex, int columnIndex) {  
    System.out.println(rowIndex + " : " + columnIndex);
    Physician p = ph.get(rowIndex);
    switch (columnIndex)
    {

        case 0:
            return p.getFirstName();
        case 1:
            return p.getLastName();
        case 2:
            return p.getPhoneNumber();
        default:
            return "Incorrect input";                          
    }
}