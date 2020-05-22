Node result = defaultValue;
int Id = ...;
for(Node n : tree) {
    if(n.LeftChildId == Id || n.RightChildId == Id) {
        result = n;
        break;
    }
}