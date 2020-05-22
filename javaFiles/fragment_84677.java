CW.SelectionChanged += (sender, intValue) => //[here you do something with intValue]

// -- OR --

CW.SelectionChanged += this.CW_SelectionChanged;

// then
private void CW_SelectionChanged(object sender, int intValue)
{
   //[here you do something with intValue]
}