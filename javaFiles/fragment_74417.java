Item maxItem = null;
int maxValue = 0;
for( Item item : items ) {
    if( item.value() > maxValue ) {
        maxItem = item;
        maxValue = item.value();
    }
}
return maxItem;