@PreUpdate
   @PrePersist
   void updateSearchString() {
      final String fullSearchString = StringUtils.join(Arrays.asList(
              login,
              firstName,
              lastName,
              email,
              Boolean.TRUE.equals(active) ? "tak" : "nie",
              profile.getDescription()),
              " ");
      this.searchString = StringUtils.substring(fullSearchString, 0, 999);
   }