private void update(@NonNull final User.UpdateFinalStep params) {

    UpdateWizard.update(dbUserService.get(params.getId())

            .field(params.getStatus())
            .withGetter(DbUser::getAccountStatus)
            .withSetter(DbUser::setAccountStatus)
            .finishField()

            .field(Optional.ofNullable(params.getUsername())
               .map(String::toLowerCase)
               .orElse(null))
            .withGetter(DbUser::getUsername)
            .withSetter(DbUser::setUsername)
            .beginValidationOfField(FieldName.USERNAME)
            .notEmptyAndMatchPattern(USERNAME_PATTERN, () -> this.checkUniqueUsername(params.getUsername(), params.getId()))
            .endValidation()

            .field(params.getLastName())
            .withGetter(DbUser::getLastname)
            .withSetter(DbUser::setLastname)
            .beginValidationOfField(FieldName.USER_LASTNAME)
            .notEmptyAndMatchPattern(LAST_NAME_PATTERN)
            .endValidation()

            .field(params.getFirstName())
            .withGetter(DbUser::getFirstname)
            .withSetter(DbUser::setFirstname)
            .beginValidationOfField(FieldName.USER_FIRSTNAME)
            .notEmptyAndMatchPattern(FIRST_NAME_PATTERN)
            .endValidation()

            .save(dbUserService::save);
}