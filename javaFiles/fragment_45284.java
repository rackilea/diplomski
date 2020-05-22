} else if (sourceQuery instanceof CustomScoreQuery) {
      final Query q = ((CustomScoreQuery) sourceQuery).getSubQuery();
      if (q != null) {
        flatten( applyParentBoost( q, sourceQuery ), reader, flatQueries);
      }
    } else if (reader != null) {  // <<====== Here it is!
      Query query = sourceQuery;
      if (sourceQuery instanceof MultiTermQuery) {
        MultiTermQuery copy = (MultiTermQuery) sourceQuery.clone();
        copy.setRewriteMethod(new MultiTermQuery.TopTermsScoringBooleanQueryRewrite(MAX_MTQ_TERMS));
        query = copy;
      }
      Query rewritten = query.rewrite(reader);
      if (rewritten != query) {
        // only rewrite once and then flatten again - the rewritten query could have a speacial treatment
        // if this method is overwritten in a subclass.
        flatten(rewritten, reader, flatQueries);

      }