// Here I'm using int16_t, because that's basically what you've declared that
// you will pass to shortTest from your Java code.
void shortTest(int16_t input) {
    printf("shortTest input: 0x%X\n", input);
}

int main() {
    shortTest(-1);
}

shortTest:
    stmfd   sp!, {r4, lr}
    mov     r1, r0              @ Just pass on input as the second argument to printf
    movw    r0, #:lower16:.LC0  @ Load string address
    movt    r0, #:upper16:.LC0  @ ...
    bl      printf              @ Call printf
    ldmfd   sp!, {r4, pc}       @ Return


main:
    stmfd   sp!, {r4, lr}
    mvn     r0, #0         @ First argument = 0xFFFFFFFF
    bl      shortTest      @ Call shortTest
    mov     r0, #0         @ Value to return from main
    ldmfd   sp!, {r4, pc}  @ Return