public Class outerClass{
    Class innerClass{
        //properties
    }

    public innerClass innerObj;
}

outerObj.innerObj = outerClass.new innerClass();