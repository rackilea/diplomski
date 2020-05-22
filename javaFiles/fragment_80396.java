class MyInfo {
    //some fields
}

interface Delete {
    void delete();
}

interface Info {
    MyInfo getInfo();
}

interface Update {
}

interface Target {
    boolean isTarget();
}

interface ClientProgramm extends Delete, Info, Target {

}

class ConcreteA implements ClientProgramm {

    @Override
    public void delete() {

    }

    @Override
    public MyInfo getInfo() {
        return null;
    }

    @Override
    public boolean isTarget() {
        return false;
    }
}