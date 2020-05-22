class Whatever {}
class Whichever {}

abstract class GenericAbstractFoo<T, V> extends SwingWorker<T, V> {}

class Foo2 extends GenericAbstractFoo<List<Whatever>, Whatever> {

    @Override
    protected List<Whatever> doInBackground() throws Exception {
        ...
    }
}

class Foo3 extends GenericAbstractFoo<List<Whichever>, Whichever> {

    @Override
    protected List<Whichever> doInBackground() throws Exception {
        ...
    }
}