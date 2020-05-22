EditableRxTextView.textChanges(editText)
            .map(CharSequence::toString)
            .debounce(200, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(input -> {
               output = //...do something with input
               editText.setText(ouput)
             }));