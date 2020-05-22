public class SomeNavigationClassPojo {
    ...
    public SomeHardwarePojo getSomeHardwarePojo() { 
        return baseItem instanceof SomeHardwarePojo ? (SomeHardwarePojo) baseItem : null; 
    }
    ...
}