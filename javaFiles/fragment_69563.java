int end = textArea.getDocument().getLength();
int start = Utilities.getRowStart(textArea, end);

while (start == end)
{
    end--;
    start = Utilities.getRowStart(textArea, end);
}

String text = textArea.getText(start, end - start);
System.out.println("(" + text + ")");