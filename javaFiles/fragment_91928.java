sub=observable.subscribe(
   this::updateText,
   error -> Toast
     .makeText(getActivity(), error.getMessage(), Toast.LENGTH_LONG)
     .show()
);