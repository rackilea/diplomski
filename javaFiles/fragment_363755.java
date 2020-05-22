class Copy {
  public boolean canPublish() {
    for (Article a: articles)
      if (!article.isVerified())
        return false;
  }
  return true;
}