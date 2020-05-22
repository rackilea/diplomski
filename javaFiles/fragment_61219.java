@UserRoles([Admin])
public void deleteProduct(){
///......
} 

@UserRoles([Admin,Normal])
public void commentProduct() {}