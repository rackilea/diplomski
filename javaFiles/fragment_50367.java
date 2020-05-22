private void btnRegexRep_Click(object sender, RoutedEventArgs e) {
    string fixThis = @"Hans4444müller,Mary555kren";
    var re = new Regex("\\d+");

    string result = "";
    int lastIndex = 0;
    string lastMatch = "";
    //Get the first match using the regular expression:
    var m = re.Match(fixThis);

    //Keep looping while we can match:
    while (m.Success) {
        //Get length of text between last match and current match:
        int len = m.Index - (lastIndex + lastMatch.Length);
        result += fixThis.Substring(lastIndex + lastMatch.Length, len) + GetRomanText(m);

        //Save values for next iteration:
        lastIndex = m.Index;
        lastMatch = m.Value;
        m = m.NextMatch();
    }

    //Append text after last match:
    if (lastIndex > 0) {
        result += fixThis.Substring(lastIndex + lastMatch.Length);
    }

    Console.WriteLine(result);
}

private string GetRomanText(Match m) {
    string[] roman = new[] { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "IX" };
    string result = "";
    // Get ASCII value of first digit from the match (remember, 48= ascii 0, 57=ascii 9):
    char c = m.Value[0];
    if (c >= 48 && c <= 57) {
        int index = c - 48;
        result = roman[index];
    }

    return result;
}