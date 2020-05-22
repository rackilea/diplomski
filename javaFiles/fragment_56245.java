viewModel.eventsHandler = ViewModelEventsHandler {

    override fun viewModelDidThisAndThat(done: Event) {
        when(done) {
            is DoneThisEvent -> handleViewModelDidThis(done.how, done.when) // Notice the automatic type casting
            is DoneThatEvent -> handleViewModelDidThat(done.location, done.withWho)
        }
    }
}