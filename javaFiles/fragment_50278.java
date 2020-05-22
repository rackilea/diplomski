String toolTip = "<html>";
for(String line : arrayOfStrings)
{
  toolTip += line +"<br>";
}
toolTip += "</html>";
myComponent.setToolTipText(toolTip);