// Sort the messages in the root of the tree, on the fly.
assert root.message.toSorted { it.value() }.toString() == '[message[attributes={}; value=Message(hello)], message[attributes={}; value=Message(world)]]'

// Count the number of messages within the 'John' folder; including 'Work' and 'Secret Stuff' folders.
assert root.John.'**'.message.size() == 3

// Calculate the average length of the messages in the 'John' folder: 52 / 3 = 17.3333333333
assert root.John.'**'.message.sum { it.value().size() } / root.John.'**'.message.size() == 17.3333333333


// Access the first message in the 'Jane' folder.
assert root.Jane.message[0].value() instanceof Message 
assert root.Jane.message[0].value().text == 'John, I know about her!'