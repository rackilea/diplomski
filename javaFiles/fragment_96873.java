public some_object recursiveMethod(List large_List) {
    //Create views of the two sublists
    List lower_half = large_List.subList(0,large_List.size()/2);
    List upper_half = large_List.subList(large_List.size()/2,large_List.size());

   //Recursively call on list views
   return procedure(recursiveMethod(lower_half),recursiveMethod(upper_half));
}

public some_object recursiveMethod2(ArrayList large_List, int begin, int end) {
    //Create views of the two sublists
    int size = end - begin;
    int lowerBegin = begin;
    int lowerEnd = begin + size/2; //exclusive
    int upperBegin = lowerEnd;
    int upperEnd = begin + size; //exclusive

   //Recursively call on list views
   return procedure(recursiveMethod2(large_List,lowerBegin,lowerEnd),recursiveMethod2(large_List,upperBegin,upperEnd));
}