Vector<?> data = entry.getColumnValues();
Object tmp = data.get(0);
Vector<?> result = new Vector();

if( tmp instanceof String ){
    result.add( (String) tmp );
}

if( tmp instanceof ArrayList ){
    ArrayList list = (ArrayList) tmp;
    for( int i=0; i<list.size(); i++ ){
        result.add( list.get(i) );
    }
}

if( tmp instanceof Vector ){
    Vector<?> vec = (Vector) tmp;
    for( int i=0; i<vec.size(); i++ ){
        result.add( vec.get(i) );
    }
}


return result;