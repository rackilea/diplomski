public class Entity {

    String source =
            "entity.loc_x += 1\n" +
            "entity.loc_z = entity.loc_x";
    ScriptEngine se;

    loc_x = 0;
    loc_y = 0;
    loc_z = 0;

    public Entity () {
        ScriptEngineManager sem = new ScriptEngineManager ();
        se = sem.getEngineByName ( "python" );
        se.put ( "entity", this );
    }

    public void update () {
        se.eval ( source );
    }
}