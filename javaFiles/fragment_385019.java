public class Matrix {
    private Object[][] values = new Object[100][100];
    private final int MN=8;
    private final int PY=58;
    private final int RB=13;

    public static void main(String[] args){
        Matrix matrix = new Matrix();
        matrix.values[8][58] = "Hello";
        try {
            System.out.println(matrix.getElement("MN","PY"));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }

    }

    public Object getElement(String rowConstant, String columnConstant) 
    throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
        return values[getConstant(rowConstant)][getConstant(columnConstant)];
    }

    private int getConstant(String constant) 
    throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
        return getClass().getDeclaredField(constant).getInt(this);
    }
}