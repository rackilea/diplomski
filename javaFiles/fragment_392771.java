import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProductCalc extends JFrame {
    public static void main(String[] args) {
        new ProductCalc();
    }

    private List<Product> productList;
    private List<JTextField> textFields;
    private List<String> caselist;

    public ProductCalc() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        productList = new ArrayList<Product>();
        productList.add(new Product("Milk", 10.00));
        productList.add(new Product("Bread", 20.00));
        productList.add(new Product("Eggs", 5.00));

        textFields = new ArrayList<JTextField>();
        for (Product p : productList) {
            textFields.add(new JTextField(10));
        }

        JPanel panel = new JPanel();
        for (int i = 0; i < textFields.size(); i++) {
            panel.add(new JLabel(productList.get(i).getName()));
            panel.add(textFields.get(i));
        }

        JButton button = new JButton("click");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panel.add(button);

        this.setSize(500, 500);
        this.add(panel);
        this.setVisible(true);
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        caselist = new ArrayList<String>();
        for (int i = 0; i < textFields.size(); i++) {
            try {
                double total = calculateTotal(textFields.get(i).getText(), productList.get(i).getPrice());
                caselist.add(productList.get(i).getName() + " Total - £" + total);
            } catch (NumberFormatException e) {
                caselist.add(productList.get(i).getName() + " invalid amount");
            }
        }
        for (String s : caselist) {
            System.out.println(s);
        }
    }

    private double calculateTotal(String amount, double cost) {
        int amnt = Integer.parseInt(amount);
        return cost * amnt;
    }
}

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}