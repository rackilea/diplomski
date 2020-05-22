function enumerateEdges(nodes, edges) {
  return nodes.length < 2 ? edges
        : nodes.reduce( (acc, end, i) => (i<2 ? [] : acc).concat(
            enumerateEdges(nodes.slice(1, i).concat(nodes.slice(i+1)), 
                           [...edges, {start:nodes[0], end}])
          ) );
}

let nodes = [1,2,3,4];
let edges = [];
let result = enumerateEdges(nodes, edges);
console.log(result);