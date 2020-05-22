public static StarRating getByDescription(String description){
    if(description == null){
        return null;
    }
    for(StarRating sr : StarRating.values()){
        if(description.equals(sr.description)){
            return sr;
        }
    }
    return null;
}