if (item1.typeInt != item2.typeInt) {
    return item1.typeInt == MyItemModel.TYPE_MAGAZINE ? 1 : -1;
} else {
    if (parseDateFromString(item1.getStartReading()) == null) {
        return 0;
    } else if (parseDateFromString(item2.getStartReading()) == null) {
        return -1;
    } else {
        return parseDateFromString(item2.getStartReading()).after(parseDateFromString(item1.getStartReading())) ? 1 : -1;
    }
}