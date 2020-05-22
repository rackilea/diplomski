if(((LineSegmentDB)other).lineSegments.size() != lineSegments.size()) {
    return false;
}

for(int i = 0; i < lineSegments.size(); i++){
    if(!(((LineSegmentDB)other).lineSegments
        .contains(lineSegments.get(i)))){
        return false;
    }
}