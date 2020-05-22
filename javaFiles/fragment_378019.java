class Television implements Remotable {

    @Override
    void turnOff() {
        System.out.println("Television is turned off");
    }

    //implements the rest.
}

class HomeTheater implements Remotable {
    // implements likes Television
}

class CDPlayer implements Remotable {
}