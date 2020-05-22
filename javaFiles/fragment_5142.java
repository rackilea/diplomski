dataModel.bind().subscribe(
    state -> {
        status.setText(state.lastModifiedBy)

        someOtherTextView.setText(state. lastModifiedAt)
    },
    error -> {
        Log.e(getClass().getName(), error)
    }
)