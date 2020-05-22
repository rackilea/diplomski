void pumpEventsForFilter(...) {
    ...
    while(doDispatch && ...) {
        pumpOneEventForFilters(...);
    }
    ...
}