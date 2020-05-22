for each domino in the collection:
    see if it can be added to the chain (either the chain is empty, or the first 
    number is the same as the second number of the last domino in the chain.
    if it can, 
        append the domino to the chain,
        then print this new chain as it is a solution,
        then call recursively with D - {domino} and C + {domino}

    repeat with the flipped domino