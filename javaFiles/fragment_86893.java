Object testList = request.getAttribute("testList");
    if (testList instanceof Collection) {
        for (Object obj : (Collection<?>) testList) {
            if (obj instanceof TestObject) {
                TestObject currentTestObject = (TestObject) obj;
                // Do something with currentTestObject
            }
        }
    }