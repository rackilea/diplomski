ResourceOrJunk roj = itemToResourceOrJunk(d);
if (roj instanceof Resource){
    Resource r = (Resource)d;
    //do stuff with resource
} else {
    Junk j = (Jurk)d;
    //do stuff with junk
}