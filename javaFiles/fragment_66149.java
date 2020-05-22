P=null
R = {1,2,...,m}
x = 0
w = t(A)*(b-A*x)
while R<>null and max{wi|i in R}>0 do:
    j = argmax{wi|i in R}
    P = P U {j}
    R = R\{j}
    s[P] = invert[t(A[P])A[P]]t(A[P])b
    while sp<=0 do:
        a = -min{xi/(di-xi)|i in P and di<0}
        x = x + a*s -x
        update(P)
        update(R)
        sP = invert[t(A[P])A[P]]t(A[P])b
        sR = 0
    x = s
    w = t(A)*(b-A*x)
return x