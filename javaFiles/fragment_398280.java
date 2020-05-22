int pizzaQTY = input.nextInt();
int pizzaCost;

if (pizzaSize == 1) {
    pizzaCost = 120;
}
else if (pizzaSize == 2) {
    pizzaCost = 140;
}
else if (pizzaSize == 3) {
    pizzaCost = 160;
}

int totAMTpizza = pizzaQTY * pizzaCost;