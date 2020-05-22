Map<String,Field> trg = asMap( target.getClass().getDeclaredFields() );

int counter = 50;

for( Field f : Source.getClass().getDeclaredFields() ){
  f.setAccessible( true );
  Field fieldTarget = trg.get( f.getName() );
  if( null != fieldTarget ){
    fieldTarget.set(target, f.get(source));
    counter--;
  }
  if( 0 == counter ) break;
}