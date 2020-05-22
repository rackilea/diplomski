int[] value = {15, 15, 9, 9, 9, 12, 8, 8, 4};

int index = 1;
int lastValue = value[0];
for( int co=0; co<value.length; co++ ){
    int thisValue = value[co];
    if( thisValue != lastValue ){
        index++;
        lastValue = thisValue;
    }
    System.out.println( "Value =: "+thisValue+" , Index = "+index );
}