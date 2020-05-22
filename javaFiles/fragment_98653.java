void myMethod(int index) {
    String[] cmd = { "-i",  imageToBeFiltered.toString(), "-filter_complex", filters[loopCounter], imageWithFilter.toString()};

    ffmpeg.execute(cmd, new ExecuteBinaryResponseHandler() {

        @Override
        public void onSuccess(String message) {
            super.onSuccess(message);

            if (index < 10) myMethod(index++);

        }
        @Override
        public void onFailure(String message) {
            super.onFailure(message);

            if (index < 10) myMethod(index++);
        }
    });
}