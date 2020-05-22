public static void createNewEntry(Document doc, Element root, String id, String fName, String lName, String sal){

    Element staff = doc.createElement("Staff");
    root.appendChild(staff);

    staff.setAttribute("id", id);

    Element firstName = doc.createElement("First_Name");
    firstName.appendChild(doc.createTextNode(fName));
    staff.appendChild(firstName);

    Element lastName = doc.createElement("Last_Name");
    lastName.appendChild(doc.createTextNode(lName));
    staff.appendChild(lastName);

    Element salary = doc.createElement("Salary");
    salary.appendChild(doc.createTextNode(sal));
    staff.appendChild(salary);

    }