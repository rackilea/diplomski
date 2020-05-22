@Override
public int compare(Item mdi1, Item mdi2) {
    int comparison = 0;
    switch(field) {
    case TIMESTAMP:
        comparison = mdi1.getTimestamp().compareTo(mdi2.getTimestamp());
    case ID:
        comparison = mdi1.getID() - mdi2.getID();
    }
    return comparison;
}