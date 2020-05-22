Map<String,Field> asMap( Field[] fields ){
  Map<String,Field> m = new HashMap<String,Field>();
  for( Field f : fields ){
    f.setAccessible( true );
    m.put( f.getName(), f );
  }
  return m;
}