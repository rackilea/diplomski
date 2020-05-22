for (Osm.Way way : i_Osm.getWay()) {
//I will asume the getNd() returns some sort of array or list an you can access the next or previous element
     for (Osm.Way.Nd nd : way.getNd()) {
                if(o_AdjList contains key nd){
                  o.AdjList.get(nd).add(nextNd);
                } else {
                  o.AdjList.put(nd,nextNd);
     }
}