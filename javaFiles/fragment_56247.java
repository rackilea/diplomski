viewModel.eventsHandler = ViewModelEventsHandler {
    override fun viewModelDidThis(String how, Date when) {
        handleViewModelDidThis(how, when)
    }

    override fun viewModelDidThis(Location where, List<Friends> withWho) {
        handleViewModelDidThat(where, withWho)
    }
}