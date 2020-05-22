ResultVoiceObject[] objects = ...
Arrays.sort(objects, new Comparator<ResultVoiceObject>() {

    @Override
    public int compare(ResultVoiceObject arg0, ResultVoiceObject arg1) {
        return Float.compare(arg0.getRanking(), arg1.getRanking());
    }

});