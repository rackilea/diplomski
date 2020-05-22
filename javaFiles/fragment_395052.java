Tree t2 = Tree.valueOf("(VP (VP (VB manage) (NP (NP (DT the) (JJ entire) (NN life) (NN cycle)) (PP (IN of) (NP (PRP$ your) (NNS APIs))))) (CC and) (VP (VB expose) (NP (PRP$ your) (NNS APIs)) (PP (TO to) (NP (JJ third-party) (NNS developers)))))");
List<Tree> trees = Collections.singletonList(t2);

String s = "@VP $+ (@CONJP|CC $+ @VP)";
TregexPattern p = TregexPattern.compile(s);
for (Tree t : trees) {
  TregexMatcher m = p.matcher(t);
  while (m.findNextMatchingNode()) {
    Tree foundTree = m.getMatch();
    System.out.println(foundTree);
  }
}