@Mapper
public interface MapperA {

}

@Mapper(uses = MapperA.class)
public interface MapperB {

}

@Mapper(uses = MapperB.class)
public interface MapperC {

}