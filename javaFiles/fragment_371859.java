IntStream.range(0, fileNames.size())
                .mapToObj(i -> "mvn deploy:deploy-file" +
                        " -DrepositoryId=" + REPO_ID +
                        " -Durl=" + REPO_URL +
                        " -Dfile=" + LIBS + fileNames.get(i) +
                        " -DgroupId=" + GROUP_ID +
                        " -DartifactId=" + artifactName.get(i) +
                        " -Dversion=" + versionNumbers.get(i) +
                        " -DgeneratePom=true")
                .map(s -> s + ";")
                .collect(Collectors.toList());