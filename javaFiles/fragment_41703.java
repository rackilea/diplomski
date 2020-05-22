private void cascadeSave(Model model) {

    model.setParameterValues(
      model.getParameterValues().stream()
       .map(param ->  parameterValueRepository.save(param))
       .collect(Collectors.toSet())
   );
    modelRepository.save(model);
}