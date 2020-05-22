Stack 1: position 5, this points to 10 (you are calling this.next.nth(4); means 20.nth())
    Stack 2: position 4, this points to 20 (calling this.next.nth(3); = 30.nth())
        Stack 3: position 3, this points to 30 (calling this.next.nth(2) = 40.nth())
            Stack 4: position 2, this points to 40 (calling this.next.nth(1) = 50.nth())
                Stack 5: position 1, this points to 50 (returning this; this here is 50)
                returns 50
            returns 50 (not going back into if, so return value remains same)
        returns 50
    returns 50
returns 50