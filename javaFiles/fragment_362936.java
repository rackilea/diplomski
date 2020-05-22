public int add(Employee employ)
{
    int index;
    for (index = 0; index < employCount; index++){
        int result = employeeArray[index].getName().compareTo(employ.getName());
        if(result == 0){
            throw new RuntimeException ("Employee Not New");
        }
    }

    if (employeeArray.length == employCount){
        expand();
    }

    employeeArray[index] = employ;
    employCount++;
    return index;
}