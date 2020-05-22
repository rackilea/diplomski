for(int i=0; i<newList.size();i++)
{
    if(sentence.isEmpty()) continue;
    content.drawString(newList.get(i));
    content.moveTextPositionByAmount(0, LINE_HEIGHT);
}