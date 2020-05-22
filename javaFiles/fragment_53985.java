@Override
     public boolean masikEllenVall(int iFordulo) {

    if(this.ellenfelValaszai.size() > iFordulo){ //if iFordulo always >= 0 it's sufficient check to be sure array isn't empty
        System.out.println(this.ellenfelValaszai.get(iFordulo));
    }

    if(this.ellenfelValaszai.size()>999){deleteList();}
    return true;
}