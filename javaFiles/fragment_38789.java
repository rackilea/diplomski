PFQuery *rolesQuery = [PFRole query]; 
NSArray *allRoles = [rolesQuery findObjects];
NSMutableArray *userRoles = [NSMutableArray arrayWithCapacity:10];
for (PFRole *role in allRoles) {
    PFQuery *usersQuery = [role relationforKey:@"users"].query;
    [usersQuery whereKey:@"objectId" equalTo:[PFUser currentUser].objectId];
    if ([usersQuery countObjects]) {
        [userRoles addObject:role];
    }
}