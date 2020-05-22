//_valueArray is my string[]
//fontSize is the value of the Size of the font...
//1.5 it's just a magic number :) that give me the space line that i need
//cbLocal is the PdfContentByte of the pdf
for (i = 0; i < _valueArray.Length; i++)
{
    var p = new Phrase(_valueArray[i], font);
    ColumnText.ShowTextAligned(cbLocal, align, p, x, y, 0);
    if (i + 1 != _valueArray.Length)
    {
        y = y - (fontSize*1.5f);
    }
}