private String getAccountID(String str)
{
    // ^ start, .* any chars, \\( open parenthesis, ([^)]*) no end parenthesis = $1,
    // \\) end parenthesis, .* $ any chars upto end.

    String accountID = str.replaceFirst("^.*\\(([^)]*)\\).*$", "$1");

    // If no matching, accountID == str.
    return accountID == str ? "" : accountID; 
}