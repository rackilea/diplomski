int elements = pTagChildren.getLength(); // save the number of nodes in a variable

while (pTagChildIndex < elements) { // loop using the variable
    textTag.appendChild(pTagChildren.item(0)); // always move the first element
    pTagChildIndex++;
}