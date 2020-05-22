@Override
public void readFields(DataInput in) throws IOException {
    int size = in.readInt();
    list= new ArrayList<Field>(size);
    for(int i = 0; i < size; i++){
        Field f = new Field();
        f.readFields(in);
        list.add(f);
    }
}

@Override
public void write(DataOutput out) throws IOException {
    out.writeInt(list.size());
    for (Field l : list) {
        l.write(out);
    }
}