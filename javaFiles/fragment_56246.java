// In activity onCreate
viewModel.iDidThis.observe(this, Observer { doneThis ->
    handleViewModelDidThis(doneThis.how, doneThis.when)
})

viewModel.iDidThat.observe(this, Observer { doneThat ->
    handleViewModelDidThat(doneThat.location, doneThat.withWho)
}



// In your ViewModel
val iDidThis: LiveData<DoneThisEvent>
val iDidThat: LiveData<DoneThatEvent>