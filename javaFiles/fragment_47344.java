Set<String, Boolean> canWinMap = new HashMap<>();

public boolean canWin(String s) {
    if (canWinMap.hasKey(s)) {
        return canWinMap.get(s);
    }
    for (int i = 0; i < s.length() - 1; ++i)
        if (s.charAt(i) == '+' && s.charAt(i + 1) == '+' && 
            !canWin(s.substring(0, i) + "--" + s.substring(i + 2)))
                canWinMap.put(s, true);
                return true;
    canWinMap.put(s, false);
    return false;
}