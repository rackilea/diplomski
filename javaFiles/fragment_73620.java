private static void listChains(List<Domino> chain, List<Domino> list) {
    for (int i = 0; i < list.size(); ++i) {
        Domino dom = list.get(i);
        if (canAppend(dom, chain)) {
            chain.add(dom);
            System.out.println(chain);
            Domino saved = list.remove(i);
            listChains(chain, list);
            list.add(i, saved);
            chain.remove(chain.size()-1);
        }
        dom = dom.flipped();
        if (canAppend(dom, chain)) {
            chain.add(dom);
            System.out.println(chain);
            Domino saved = list.remove(i);
            listChains(chain, list);
            list.add(i, saved);
            chain.remove(chain.size()-1);
        }
    }
}

private static boolean canAppend(Domino dom, List<Domino> to) {
    return to.isEmpty() || to.get(to.size()-1).b == dom.a;
}