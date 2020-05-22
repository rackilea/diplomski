public enum Perspective{
    A, B, C
}

public enum Thing{

    FOO(Perspective.A, Perspective.B),
    BAR(Perspective.C),
    BAZ(Perspective.A, Perspective.B, Perspective.C),
    ;
    private final Perspective[] perspectives;
    private Thing(Perspective ... perspectives){
      this.perspectives=perspectives;
    }

    public static Set<Thing> forPerspective(Perspective p){
        Set<Perspective> set = EnumSet.noneOf(Perspective.class);
        for(Thing t : values()){
            if(EnumSet.of(t.perspectives).contains(p)){set.add(t);}
        }
        return t;
    }
}