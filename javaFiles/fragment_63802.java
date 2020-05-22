SpanTermQuery goldenQ = new SpanTermQuery(new Term("content", "golden"));
SpanTermQuery fleeceQ = new SpanTermQuery(new Term("content", "fleece"));
SpanTermQuery blackQ = new SpanTermQuery(new Term("content", "black"));

SpanQuery[] subclauses = {goldenQ, fleeceQ};
SpanNearQuery goldfleeceQ = new SpanNearQuery(subclauses, 0, true); //No slop, in order!

SpanQuery[] mainclauses = {goldfleeceQ, blackQ};
SpanNearQuery finalQ = new SpanNearQuery(mainclauses, 10, false); //As before, 10 slop, any order