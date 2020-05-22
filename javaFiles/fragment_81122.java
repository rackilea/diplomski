new Consumer<Event>() {
    @Override
    public void accept(Event evt) {
        for (String a: Arrays.asList("jhoeller,dsyer,pwebb,ogierke,rwinch,mfisher,mpollack,jlong".split(",")) {
            Account account = accountRepository.save(new Account(a,
                    "password"));
            bookmarkRepository.save(new Bookmark(account,
                    "http://bookmark.com/1/" + a, "A description"));
            bookmarkRepository.save(new Bookmark(account,
                    "http://bookmark.com/2/" + a, "A description"));
        }
    }
}