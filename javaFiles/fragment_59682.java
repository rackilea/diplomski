catch (ReflectiveOperationException e) {
        // means caller did not call one of the supported classes (Npc)
        // or the class does not have the expected constructor
        // react in some way
        e.printStackTrace();
}