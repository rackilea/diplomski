private void getViewModelAndWords() {

        Log.i(TAG, String.format("getViewModelAndWords() called from %s", Thread.currentThread().getName()));

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        viewModel.wordList.observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                //Do something with youre result
                Log.i(TAG, String.format("viewModel.wordList livedata returned %d results", words != null ? words.size() : -1));
            }
        });

        viewModel.getAllWords();


        Log.i(TAG, "viewModel.getAllWords() done");


    }