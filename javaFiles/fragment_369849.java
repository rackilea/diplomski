while (true){
        String option = in.nextLine() ; 
        if(!"6".equals(option)) {
            if ("2a".equals(option)) { // Define new department
                ...
                List<Department> departmentList;
               //here create a new arrayList
               departmentList = new ArrayList<>();
             //try to add element without index
               //  departmentList.add(Department_Name);
             //try to add element with index
               departmentList.add(d, Department_Name);
                d++ ;
                ....

            }
        }