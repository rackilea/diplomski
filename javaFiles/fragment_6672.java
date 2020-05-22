public static void main(String[] args) {
    try {
        throw new RuntimeException("Cannot move file");
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
    }
}