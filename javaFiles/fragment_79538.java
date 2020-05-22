class Store {
   string name;
   // other stuff
}

class Area {
    string name;
    Map<string, Store> stores;
    // other stuff;
}

class City {
    string name;
    Map<string, Area> areas;
    // other stuff
}

class State {
    string name;
    Map<string, City> cities;
    // other stuff
}

class Country {
    string name;
    Map<string, State> states;
    // other stuff
}