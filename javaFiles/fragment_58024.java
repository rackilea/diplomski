List<VarsRecord> list = new ArrayList<>(vars.size());
for (Var var : vars) {
    VarsRecord rec = new VarsRecord();
    rec.from(var);
    list.add(rec);
}
create.batchInsert(list).execute();