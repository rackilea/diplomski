records[i] = records[i-1];

# records[4] = records[3]; 
# BUT what actually happens here is records[4] is now pointing to the 
# same piece of memory as records[3]. So then:
# records[4] => memory_address_x
# records[3] => memory_address_x

records[insertScoreHere].setName(uName);
records[insertScoreHere].setScore(uScore); 

#so now this code: records[3].setName(uName); is actually modifying 
#the same piece of memory as records[4].