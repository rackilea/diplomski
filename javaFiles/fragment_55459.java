public Engine mapEngineShared(ResultSet rs) throws SQLException {
    Engine engine = new Engine();
    engine.setId("ENGINE_ID"); // Aliased from "ID"
    engine.setId("ENGINE_MODEL_TYPE"); // Aliased from "MODEL_TYPE"
    return engine;
}