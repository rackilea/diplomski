HighestObject h = ...;

boolean foundNotX = h.getObjectList().stream() //Stream<SomeObject>
                  .flatMap(so -> so.getObjectList().stream()) //Stream<DummyObject>
                  .mapToDouble(o -> o.first + o.second + o.third + o.fourth) //DoubleStream
                  .anyMatch(sum -> sum != X);
if (foundNotX) return false;