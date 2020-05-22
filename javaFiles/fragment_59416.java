public int compareTo(Patient a){
    if(emergency==a.emergency)
        return 0;       
    else if(emergency>a.emergency)
        return 1;
    else
        return -1;          
}