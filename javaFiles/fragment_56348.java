n1 := n
n2 := n+1
n3 := 2n+1
if n1 % 2 == 0 { n1 /= 2 } else { n2 /= 2 }
if n1 % 3 == 0 { n1 /= 3 } else if n2 % 3 == 0 { n2 /= 3 } else { n3 /= 3}
return (((n1 % M) * (n2 % M)) % M * (n3 % M)) % M