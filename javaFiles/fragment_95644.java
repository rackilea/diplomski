class Actor {
 // Use Greenfoot Actor class instead of this one
}

interface ITransportation {

    public void load(Transportable goods);
}

class Transportation extends Actor implements ITransportation{

    @Override
    public void load(Transportable goods) {

    }
}

class Truck extends Transportation{

}

interface ITransportable {

}

class Transportable extends Actor implements ITransportable {

}
class Container extends Transportable {

}

class HybridGood implements ITransportable, ITransportation {

    private Transportation transportation;
    private Transportable transportable;

    @Override
    public void load(Transportable goods) {
        transportation.load(goods);
    }
}
class Bike extends HybridGood {

}