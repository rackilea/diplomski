public Set<QueryableEntry> getRecords(Comparable attributeValue) {
    long timestamp = this.stats.makeTimestamp();
    if (this.converter == null) {
      this.stats.onIndexHit(timestamp, 0L);
      return new SingleResultSet((Map)null);
    } else {
      Set<QueryableEntry> result = this.indexStore.getRecords(this.convert(attributeValue));
      this.stats.onIndexHit(timestamp, (long)result.size());
      return result;
    }
  }