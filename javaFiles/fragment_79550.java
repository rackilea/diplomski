public static Blender createBlender(String type){
    switch(type){
    case "Cuisinart": return new Cuisinart();
    case "Oster": return new Oster();
    //etc
    }
}