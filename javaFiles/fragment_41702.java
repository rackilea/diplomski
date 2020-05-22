private void cascadeSave(Model model) {

    modelRepository.save(model);
    //ParamValues will be saved/updated automaticlly if your model has changed

}