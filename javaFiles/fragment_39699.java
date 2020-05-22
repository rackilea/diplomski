mockery.checking(new Expectations() {{
    one(mockObject).a();

    allowing(mockObject).b();
    allowing(mockObject).c();
}});