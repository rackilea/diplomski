public static final int IsSingle = 1 << 0;
public static final int IsGraduate = 1 << 1;
public static final int IsMale = 1 << 2;
public static final int IsLookingForPartner = 1 << 3;

...

if ((Value & IsSingle) != 0) {
}

if ((Value & IsGraduate) != 0) {
}

// Set "Single"
Value |= IsSingle;

// Remove "Graduate"
Value &= ~IsGraduate;