for (int j = 0; j < mapA.size(); j++) {
    boolean found=false;
    for (int k = 0; k < mapB.size(); k++) {
        if (mapA.get(j).get("folio").toString().equals(
            mapB.get(k).get("folio").toString())) {
            found=true;   
            break;
        }
    }

    if (!found){
       m++; // count many records not exist on mapB
    }
}