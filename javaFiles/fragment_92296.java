class Whatever {}

abstract class AbstractFoo extends SwingWorker<List<Whatever>, Whatever> {}

class Foo1 extends AbstractFoo {

    @Override
    protected List<Whatever> doInBackground() throws Exception {
        ...
    }
}