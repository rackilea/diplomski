int c = 0;
while(rs3.next()) {
    inventory[c][0] = rs3.getString(10);                    
    inventory[c][1] = rs3.getString(9);                     

    System.out.println(inventory[c][1]);

    // ... rest omitted for brevity

    c++;
}