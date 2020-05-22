int i = 0;
for (RecordValueTimestampTableHolder item : valueTimestampMap.values()) {
    recordValueHolder.add(item);
    if (++i == 100)
        break;
}