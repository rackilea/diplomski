public ProvinceTerritory[] getProvinceWhoseNameContains(String substring){
    ProvinceTerritory[] names = new ProvinceTerritory[13];
    int j=0;

    for(ProvinceTerritory ptt:provinces){
        if(ptt.getName().contains(substring)){
            names[j]= ptt;
            j++;
        }
    }
    return names;  
}