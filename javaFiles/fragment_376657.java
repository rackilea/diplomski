// Bottom-up
function f(A, k){
  let M = new Array(A.length)
  
  for (let i=0; i<A.length; i++)
    M[i] = new Array(2*k + 1).fill(0)

  // Base case - force buy
  for (let j=1; j<=2*k; j+=2)
    M[0][j] = -A[0]

  for (let i=1; i<A.length; i++){
    for (let j=1; j<=2*k; j++){
      if (j & 1){
        M[i][j] = Math.max(
          -A[i] + M[i-1][j-1], // buy
          M[i - 1][j]
        )
     
      } else {
        M[i][j] = Math.max(
          A[i] + M[i-1][j-1], // sell
          M[i-1][j]
        )
      }
    }
  }

  return M[A.length-1][2*k]
}

var inputs = [
  [[10, 22, 5, 75, 65, 80], 2], // 87
  [[12, 14, 17, 10, 14, 13, 12, 15], 3], // 12
  [[100, 30, 15, 10, 8, 25, 80], 3], // 72
  [[90, 80, 70, 60, 50], 1] // 0
]

for (let [A, K] of inputs){
  console.log(`A: ${A}, K: ${K}`)
  console.log(f(A, K))
}