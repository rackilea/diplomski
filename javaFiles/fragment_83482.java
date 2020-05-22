class AnException extends Exception {};
class SpecialException extends AnException {};

interface TheInterface {
    public void method() throws AnException;
}