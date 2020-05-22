// Odd k means the (k/2)th buy was completed
function f(A, k, i=A.length-1){
  // All transactions were done
  if (k == 0)
    return 0
  // We're at the start of the price list
  // so if we are in the middle of a transaction,
  // force the associated "buy"
  if (i == 0)
    return k & 1 ? -A[0] : 0
  
  // Current k is odd so we have completed a "sell" -
  // choose to record the associated "buy" or skip
  if (k & 1){
    return Math.max(
      -A[i] + f(A, k - 1, i - 1), // buy
      f(A, k, i - 1) // skip
    )
  // Current k is even so we have completed a "buy" or
  // are "at rest" - choose to record a new "sell" or skip
  } else {
    return Math.max(
      A[i] + f(A, k - 1, i - 1), // sell
      f(A, k, i - 1) // skip
    )
  }
}

var inputs = [
  [[10, 22, 5, 75, 65, 80], 2], // 87
  [[12, 14, 17, 10, 14, 13, 12, 15], 3], // 12
  [[100, 30, 15, 10, 8, 25, 80], 3], // 72
  [[90, 80, 70, 60, 50], 1] // 0
]

for (let [A, K] of inputs){
  console.log(`A: ${A}, K: ${K}`)
  console.log(f(A, 2*K)) // call with doubled K
}