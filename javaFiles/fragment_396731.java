public boolean satisfies(QuakeEntry qe) { 
    for(Filter f : filt) {
        if (f.satisfies(qe)) { // one of the filters worked, let's exit
            return true;
        }
    }
    return false;
}