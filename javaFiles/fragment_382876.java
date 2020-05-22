Map<String,String> map=new HashMap<String,String>(); //key-Value pair
map.put("cat",""furry\n white"); // \n So that you will get a new line character in text area
map.put("dog","greyhound \n beast");
JFrame frame = new JFrame();
frame.setLayout(new GridLayout(rows,columns));//In your case (map.size,2)
frame.setSize(300, 300);

//Now You need to Iterate through the Map.

for(Map.Entry<String,String>entry:map.entrySet()){
  JTextArea left=JTextArea(entry.getKey());
  JTextArea right=JTextArea(entry.getValue());
  frame.add(left);  //Adding each key to the Frame on left side
  frame.add(right); //This is the value you want in side of key
 }

frame.setVisible(true);