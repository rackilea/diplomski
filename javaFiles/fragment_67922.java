function enumerateEdges(nodes, edges) {
  if (nodes.length < 2) return [...edges]; // return copy
  let start = nodes[0];
  let acc = [];
  for(let i = 1; i < nodes.length; i++) {
    let end = nodes[i];
    edges.push({start, end}); // don't overwrite, but push 
    let unused = nodes.slice(0);
    unused.splice(i,1);
    unused.splice(0,1);
    // The spread operator will put each of the array elements as separate arguments
    // ... so no more need for the mysterious apply:
    acc.push(...enumerateEdges(unused, edges));
    edges.pop(); // in practice it is always the last element to be removed
  }
  return acc;
}

let nodes = [1,2,3,4];
let edges = [];
let result = enumerateEdges(nodes, edges);
console.log(result);