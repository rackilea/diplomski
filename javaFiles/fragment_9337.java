boolean ascending = false;
    SortField idSortField = new SortField("id", SortField.Type.LONG, ascending);

    SortingMergePolicy sortingMP = new SortingMergePolicy(
            iwc.getMergePolicy(), new Sort(idSortField));
    iwc.setMergePolicy(sortingMP);