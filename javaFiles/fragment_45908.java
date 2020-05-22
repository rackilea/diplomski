for (Employee emp : firstList) {
        boolean found=false;
        for (Employee tgtEmp : seconList) {
            if ((emp.getHolDate().equals(tgtEmp.getHolDate())) && (emp.getHolName().equals(tgtEmp.getHolName()))) {
                found=true;
                break;
            }
        }
        if(!found){
            printList.add(emp);
        }
    }