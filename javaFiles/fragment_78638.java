LexMax(S)
{
    if Length(S) = 1
        return S
    else
    {
        LMA = LexMax(S[0:Length/2])
        LMB = LexMax(S[Length/2:end])
        return Merge(LMA,LMB)
    }
}

Merge(A,B)
{
    Sa = A
    Sb = B

    for n = 0:Length(A)
    {
        if Sb contains A[n]
        {
            if A[n+1:end] contains character > A[n]
                Remove A[n] from Sa
            else
                Remove A[n] from Sb
        }
    }

    return Sa + Sb
}