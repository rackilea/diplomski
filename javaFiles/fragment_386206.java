...
    if (amount.isEmpty())
        throw new IllegalArgumentException();
    ...

} catch (NumberFormatException numbere) {
    System.out.println("Either Number format is uncorrect, Try Again.");
} catch (IllegalArgumentException empty) {
    System.out.println("String is empty, Try Again.");
}