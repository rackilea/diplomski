input: N is a set of all nodes in the graph
S += {r | r in N && r has no incoming connections }  // a set with the root nodes
I := {n -> |predecessors(n)| | n in N}  // a mapping from the nodes to numbers, the numbers being the numbers of incoming edges to the nodes
ordering := []  // a list of nodes
while |S| > 0  // while the open set is non-empty
    n := arg min_q {K(q) | q in S}  // from the open set, select the node with the lowest assigned number (see above)
    S -= {n}  // remove the node from the open set
    ordering += n  // add the node to the ordering
    for each q in successors(n)
        I[q] -= 1  // decrease the number of incoming nodes for each successor of n
    S += {q | I[q] == 0}  // add all nodes that have no incoming edge left to S
return ordering