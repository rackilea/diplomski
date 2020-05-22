public static interface ILoadData {

    public void loadData();
}

public static interface ILoadRecord {

    public void loadRecord();
}

public static interface ILoadEither extends ILoadData, ILoadRecord {
}

public static class ClassOne implements ILoadData {

    @Override
    public void loadData() {
        System.out.println("CLASS ONE LOADING DATA ");
    }
}

public static class ClassTwo implements ILoadData {

    @Override
    public void loadData() {
        System.out.println("CLASS TWO LOADING DATA");
    }
}

public static class ClassThree implements ILoadRecord {

    @Override
    public void loadRecord() {
        System.out.println("CLASS THREE LOADING RECORD");
    }
}

public static class ClassFour implements ILoadRecord, ILoadData {

    @Override
    public void loadRecord() {
        System.out.println("CLASS FOUR LOADING RECORD");
    }

    @Override
    public void loadData() {
        System.out.println("CLASS FOUR LOADING DATA");
    }
}

public static class ClassFive implements ILoadEither {

    @Override
    public void loadRecord() {
        System.out.println("CLASS FIVE LOADING RECORD");
    }

    @Override
    public void loadData() {
        System.out.println("CLASS FIVE LOADING DATA");
    }
}

public static void load(ILoadData o) {
    o.loadData();
}

public static void load(ILoadRecord o) {
    o.loadRecord();
}

public static void load(ILoadEither o) {
    o.loadRecord();
}

public static void main(String[] args) {
    load(new ClassOne());
    load(new ClassTwo());
    load(new ClassThree());
    load((ILoadData)new ClassFour());
    load((ILoadRecord)new ClassFour());
    load(new ClassFive());
}