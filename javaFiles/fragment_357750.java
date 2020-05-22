findMatches(treeNode, searchNode) {
    if searchNode has no children {
        // search successful
        pairs = []  // empty list
        return [pairs]  // list of lists
    }
    else {
        matches = []  // empty list
        searchChild = first child node of searchNode
        searchNode2 = searchNode with searchChild removed
        // NOTE: searchNode2 is created by doing a shallow copy of just the node
        // (not it's children) and then removing searchChild from the child list.

        for each treeChild in treeNode.children {
            if treeChild.value == searchChild.value {
                treeNode2 = treeNode with treeChild removed  // also a shallow copy
                childMatches = findMatches(searchChild, treeChild)
                nodeMatches = findMatches(treeNode2, searchNode2)

                // cross-product
                for each nodeMatchPairs in nodeMatches {
                    for each childMatchPairs in childMatches {
                        fullMatchPairs = [(searchChild, treeChild)]
                            + childMatchPairs + nodeMatchPairs  // concatenate lists
                        add fullMatchPairs to matches
                    }
                }
            }
        }

        return matches
    }
}