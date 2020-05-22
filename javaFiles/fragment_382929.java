package stuff.components;
class Component {
    public Component() {
        ConnectServer.Server.onInstanceCreated(this.getClass());
    }
}

class Human extends Component {
    public Human(){
        // implicit call to Component constructor
    }
}

class Dog extends Component{
    public Dog(){
        // implicit call to Component constructor    
    }
}