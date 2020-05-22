@Override
public int compare(Patient p1, Patient p2) {

    if (p1.isPreviouslyInQueue() && !p2.isPreviouslyInQueue()) 
        return -1;
    if (!p1.isPreviouslyInQueue() && p2.isPreviouslyInQueue()) 
        return 1;
    return 0;
}