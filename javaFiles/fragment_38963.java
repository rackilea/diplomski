String result = "";    
for(int i = 0; i < list.size(); i++)
{
    result += list.get(i).toString();
}

textArea.setText(result);