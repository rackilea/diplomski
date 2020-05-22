Repositories repositories = new Repositories(beanFactory);

for (Class<?> domainType : repositories) {
  RepositoryInformation info = repositories.getRepositoryInformationFor(domainType);
  …
}