Snapshot<K, V> viewport = map.lockSnapshot();
try {
    ... // work with version-fixed viewport.
} finally {
    map.unlockSnapshot(viewport);
}