function onUse(object, healValue) {
    if (object.hasComponent(HP_COMPONENT)) {
        val hp = object.getComponent(HP_COMPONENT);
        hp.value += healValue;
    }
}