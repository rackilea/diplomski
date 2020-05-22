static final Map<String, Feature> map = ...
static <F extends Enum & Feature> void addEnums(F... features) {
    for(F f: features)
       map.put(f.name(), f);
}

addEnums(FeatureA.values());
addEnums(FeatureB.values());