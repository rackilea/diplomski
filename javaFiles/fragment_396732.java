public boolean satisfies(QuakeEntry qe) { 
    for(Filter f : filt){
        if (!f.satisfies(qe)) { // any of the filters criteria failed, then exit
            return false;
        }
    }
    return true; // the code will only reach this point if all the filters were applied
}