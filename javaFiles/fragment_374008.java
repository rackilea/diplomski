public String getProfilePictureURL() {
    if ("male".equals(gender) && age >= 18) return "url for man image";
    else if ("male".equals(gender) && age < 18) return "url for boy image";    
    else if ("female".equals(gender) && age >= 18) return "url for woman image";
    else if ("female".equals(gender) && age > 18) return "url for girl image";
    else return null;
}