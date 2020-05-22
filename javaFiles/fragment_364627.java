total = 1; //you could change this to anything

x = total/3;
y = total/3;
z = total/3;

def increaseX(amount) {
    x = x + amount;
    y = y - amount/2;
    z = z - amount/2;
}

def increaseY(amount) {
    y = y + amount;
    x = x - amount/2;
    z = z - amount/2;
}

def increaseZ(amount) {
    z = z + amount;
    x = x - amount/2;
    y = y - amount/2;
}