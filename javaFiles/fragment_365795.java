ResultActions resultActions = mvc.perform(...);
 List<String> languagesToBePresent = new ArrayList<>(); //add some values here

 for (String language : languagesToBePresent) {
            resultActions.andExpect(
                  jsonPath("$.translationProperties", Matchers.hasKey(language)));
        }