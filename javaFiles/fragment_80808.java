@ProcessElement
public void processElement(ProcessContext c){
  try {
    String line = c.element(); 
    Table table = /* create the table */;             
    // fill table
    for (Table_Struct st: this.struct){
      String o = line.substring(st.pos_1, st.pos_2));
      this.table.getClass().getField(st.Field_Name)
        .set(table, o);                                                                     
    }
    c.output(table);
  }
}