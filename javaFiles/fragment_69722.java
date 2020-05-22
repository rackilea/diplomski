class MyFooService extends MyService<Foo> {
    void delete(Foo obj) {
        //execute some foo deletion logic
        // finally, invoke super class as it knows how to do the real delete action
        super.delete(obj);
    }
}