//Creating map (Note: Since order is important, use a "Linked" map)
Map<String, String> questionsMap = new LinkedHashMap();

//Storing Q&As:
questionsMap.put("Question 1", "Answer 1");
questionsMap.put("Question 2", "Answer 2");
questionsMap.put("Question 3", "Answer 3");

//Getting individual As from Qs (Qs as Object):
questionsMap.get(questionObject);

//=====This might be as follows in your code specifically:
questionsMap.get(jLabel4.getText());

//Getting individual Qs (from index):
questionsMap.keySet().toArray()[index];

//Getting individual As (from index):
questionsMap.values().toArray()[index];

//Getting individual Key-Value pairs (Q-A pairs):
Entry<String, String> entry = (Entry)questionsMap.entrySet().toArray()[index];
entry.getKey(); //Question
entry.getValue(); //Answer

//Iterating through all Key-Value pairs:
for (Entry<String, String> currentEntry : questionsMap.entrySet()){
  currentEntry.getKey(); //Question
  currentEntry.getValue(); //Answer
}