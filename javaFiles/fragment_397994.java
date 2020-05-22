public Page<Friend> findFriends(FriendCriteria friendCriteria, Pageable pageable){
   //Find actual content from friendCriteria and call method below.

  extractPage(pageable, <actual content>);

}


public static <T> Page<T> extractPage(Pageable page, List<T> contents) {
        int startIndex = page.getPageNumber() == 0 ? page.getPageNumber() : page.getPageNumber() + page.getPageSize();
        int toIndex = startIndex + page.getPageSize();
        toIndex = toIndex > contents.size() ? contents.size() : toIndex;

        final int total = contents.size();

        List<T> filteredContents;

        if (startIndex < contents.size()) {
            filteredContents = contents.subList(startIndex, toIndex);
        } else {
            filteredContents = new ArrayList<>();
        }

        TotalSupplier totalSupplier = () -> {
            return total;
        };

        return PageableExecutionUtils.getPage(filteredContents, gotoPage(page.getPageNumber(), page.getPageSize()),
                totalSupplier);
    }

    private static PageRequest gotoPage(int number, int size) {
        return new PageRequest(number, size);
    }