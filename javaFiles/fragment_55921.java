function f(A, K){
  let m = new Array(K + 1).fill(0)
    
  for (let a of A){
    for (let k=K; k>=a; k--)
      if (m[k - a])
        m[k] = Math.max(m[k], 1 + m[k - a])

    m[a] = Math.max(m[a], 1)
  }
  
  return m[K]
}

var A = [1, 2, 8, 1, 1, 7]
var K = 10

console.log(f(A, K))