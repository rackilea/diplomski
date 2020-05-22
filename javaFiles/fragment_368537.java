public void onSpeakCommandReceived(final String question) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvQuestion.setText(question);
            }
        });
    }