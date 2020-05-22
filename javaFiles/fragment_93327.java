interface Car {
default void defaultCarImpl(Engine e){
e.defaultEngineImpl();
} 

}

interface Engine{
default void defaultEngineImpl(){
//task
} 
}

class CarImp implements Car{

}

class EngineImpl implements Engine {
}