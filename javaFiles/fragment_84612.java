static ListNode *merge(ListNode *list1, ListNode *list2) {
    ListNode *head = NULL;
    ListNode **nextp = &head;
    while (list1 && list2) {
        if (list1->val <= list2->val) {
            *nextp = list1;
            nextp = &list1->next;
            list1 = list1->next;
        } else {
            *nextp = list2;
            nextp = &list2->next;
            list2 = list2->next;
        }
    }
    *nextp = list1 ? list1 : list2;
    return head;
}