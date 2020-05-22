private int idval = 0;

public int getIdval() {
    return idval;
}

public void setIdval(int idval) {
    this.idval = idval;
}

private boolean isValidId(int idValue){
    if(idValue >= 0 && idValue <= 100){
        return true;
    }
    else{
        return false;
    }
}

public void userId(){

    Scanner reader = new Scanner(System.in);
    System.out.print("Enter ID: ");
    int id = reader.nextInt();

    if(isValidId(id)){
        setIdval(id);
    }
    else{
        System.out.println("Invalid ID")
        userId();
    }

    reader.close();
}