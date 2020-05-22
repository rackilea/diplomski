public class Params implements TabSerializable{
    //fields omitted for brevity.
    ...

    public String toTabbedString(){
        StringJoiner joiner = new StringJoiner("\t");

        TabSerializer.addValue(dataType, joiner);
        TabSerializer.addValue(group, joiner);
        TabSerializer.addValue(aggregates, joiner);
        TabSerializer.addValue(scene, joiner);
        TabSerializer.addValue(company, joiner);
        TabSerializer.addValue(fit, joiner);
        TabSerializer.addValue(params, joiner);
        TabSerializer.addValue(tempo, joiner);
        TabSerializer.addValue(id, joiner);
        TabSerializer.addValue(valuation, joiner);

        return joiner.toString();
    }
    ...
}