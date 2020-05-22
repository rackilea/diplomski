i: execute n times{ //Time complexity=n*(n*(1*m^2))=O(n^2*m^2)
    j: execute n times{ //Time complexity=n*(1*m^2)
        if statement: execute ONCE{ //Time complexity=1*m^2
            dividend[j] = dividend[j] / divisor[i]; //Time complexity=m^2
        }
    }
}