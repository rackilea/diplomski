boolean first = true;

//if lists l1, l2 still have a value, append to l3
while (l1 != null || l2 != null)
{
    // create the next node
    if (!first) {
        // create the next node and attach it to the current node
        l3.next = new ListNode(0);
        // we now work with the next node
        l3 = l3.next;
    } else {
        first = false;
    }

    //if l1.val + l2.val >= 10 from last iteration, carry over 1
    if (carryover)
    {
        l3.val += 1;
        carryover = false;
    }

    if (l1 != null)
    {
        l3.val += l1.val;
        l1 = l1.next;
    }

    if (l2 != null)
    {
        l3.val += l2.val;
        l2 = l2.next;
    }

    if (l3.val > 9)
    {
        l3.val -= 10;
        carryover = true;
    }
    System.out.println(l3.val);

}