// add a new dvd to the end, increasing the array size
public void add(RatedDVD p) {
    RatedDVD[] temp = new RatedDVD[dvdlist.size()+1];
    for (int i = 0; i < dvdlist.size(); i++) {
            temp[i] = dvdlist[i];
    }
    temp[temp.length-1] = p; // add it at the end
    dvdlist = temp;
}