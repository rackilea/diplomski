List<string> termSet = fieldQuery.getTermSet(fieldName);
        VectorHighlightMapper tfv = new VectorHighlightMapper(termSet);    
        reader.GetTermFreqVector(docId, fieldName, tfv);  // <-- look at this line

        string[] terms = tfv.GetTerms();
        foreach (String term in terms)
        {
            if (!termSet.Contains(term)) continue;
            int index = tfv.IndexOf(term);
            TermVectorOffsetInfo[] tvois = tfv.GetOffsets(index);
            if (tvois == null) return; // just return to make null snippets
            int[] poss = tfv.GetTermPositions(index);
            if (poss == null) return; // just return to make null snippets
            for (int i = 0; i < tvois.Length; i++)
                termList.AddLast(new TermInfo(term, tvois[i].GetStartOffset(), tvois[i].GetEndOffset(), poss[i]));