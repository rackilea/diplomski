Terms terms = MultiFields.getTerms(indexReader, "text");
TermsEnum termsEnum = terms.iterator();
List<Term> matchingTerms = new ArrayList<Term>();
termsEnum.seekCeil(new BytesRef("app"));
while (termsEnum.term().utf8ToString().startsWith("app")) {
    matchingTerms.add(new Term("text", termsEnum.term()));
    termsEnum.next();
}
System.out.println(matchingTerms);