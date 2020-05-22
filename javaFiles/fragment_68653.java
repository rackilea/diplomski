struct Node *newNode = malloc(sizeof(struct Node));
newNode->key = key;
newNode->value = value;
newNode->left = NULL;
newNode->right = NULL;
return newNode;