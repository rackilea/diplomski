public class QDSLAliasRegistry {

private static QDSLAliasRegistry inst;

public static QDSLAliasRegistry instance() {
    inst = inst == null ? new QDSLAliasRegistry() : inst;
    return inst;
}

private QDSLAliasRegistry() {
    registry = HashBiMap.create();
}

HashBiMap<String, Path<?>> registry;