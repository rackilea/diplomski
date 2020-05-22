public static ListNode AddTwoNumber(ListNode first, ListNode second){

ListNode dummy = new ListNode(0);
ListNode node = dummy;
int Digitsten = 0;
int sum = 0;

while (first != null || second != null || Digitsten != 0) 
{
    if (first != null && second != null) 
    {
        sum += first.data + second.data + Digitsten;
    } 
    else if (first!= null) 
    {
        sum += first.data + Digitsten;
    } 
    else if (second!= null) 
    {
        sum += second.data + Digitsten;
    }
    else
    { 
        sum=Digitsten; `enter code here`
    }

    int DigitsOne = sum % 10;
    Digitsten = sum / 10;

    // LOOK HERE!!!
    node.next = new ListNode(DigitsOne);
    node = node.next;


    if (first == null) 
    {
        first = null;
    } 
    else
        first = first.next;

    if (second == null) 
    {
        second = null;
    } 
    else 
    {
        second = second.next;
    }
    sum=0;
}
return dummy.next;//return the value to dummy ListNode