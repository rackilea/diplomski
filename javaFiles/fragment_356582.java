Node current = head;
while (current.link.link != null)
    current = current.link;
int result = current.link.data;
current.link = null;
return result;