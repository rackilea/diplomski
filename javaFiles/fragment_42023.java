boolean found = false;
    for (Person p: people){
        if(current_login.equals(p.getF_name())  && pass.equals(p.getPassword())){
            found = true;
            break;
        }
    }

    if(found){
        System.out.println("\nHello " + p.getF_name() + " " + p.getL_name());
    }
    else{
        login_count--;
        System.out.println("\nYou have " + login_count + " tries");
    }