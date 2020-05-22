static ArrayList<CRM> remarksList = new ArrayList<CRM>();

public ArrayList<CRM> conditionsChecking() {
    for (CRM crm : App.actionsList) {
        CRM remarkObject = new CRM();

        remarkObject.setNumber(crm.getNumber());
        remarkObject.setDealer(crm.getDealer());
        remarkObject.setName(crm.getName());
        remarkObject.setGroup(crm.getGroup());
        //etcetera, etcetera, all setters, except remark

        if ((crm.getClientStatus().equals("Yes")) && ((crm.getAdress().isEmpty())))
            crm.setRemark("Client's address is empty");
        else if ((crm.getClientStatus().equals("Yes")) && (crm.getPhone().isEmpty()))            
            crm.setRemark( "Phone field is empty");
        // etc, etc
        else
            remarksList.add(remarkObject);
    }
    return remarksList;
}