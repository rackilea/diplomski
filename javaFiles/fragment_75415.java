JTextArea textArea = new JTextArea();
textArea.setBounds(10, 11, 864, 540);
textArea.setWrapStyleWord(true);
getContentPane().add(textArea);
for (int i = 0; i < nodes.getLength();i++)
{
     Element element = (Element)nodes.item(i);

     textArea.append("Title: " + getElementValue(element,"title") + "\n");
     textArea.append("Link: " + getElementValue(element,"link") + "\n");
     textArea.append("Publish Date: " + getElementValue(element,"pubDate") + "\n"); 
}