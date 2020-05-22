public class RowList extends ArrayList<List<Value>> {

    @Override
    public boolean add(List<Value> e) {
        // TODO Custom code to check and what not
        return super.add(e);
    }
}

RowList rl = new RowList();
List<Value> row = new ArrayList<Value>();
row.add(new Value(...));
rl.add(row);
List<Value> rowGet = rl.get(i);