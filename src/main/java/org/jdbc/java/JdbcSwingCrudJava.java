package org.jdbc.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JdbcSwingCrudJava extends JFrame {

    private JTextField nameField = new JTextField();
    private JTextField priceField = new JTextField();

    private JTextField quantityField = new JTextField();


    Container panel;


    public JdbcSwingCrudJava() {
        super("Gui: CRUD de datos con SQLserver");;
        panel = getContentPane();
        panel.setLayout(new BorderLayout(20, 10));
        JPanel formalPanel = new JPanel(new GridLayout(4, 2, 20, 10));

        formalPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JButton btnsave = new JButton("Guardar");
        formalPanel.add(new JLabel("Nombre: "));
        formalPanel.add(nameField);
        formalPanel.add(new JLabel("Precio: "));
        formalPanel.add(priceField);
        formalPanel.add(new JLabel("Cantidad: "));
        formalPanel.add(quantityField);
        formalPanel.add(new JLabel(""));
        formalPanel.add(btnsave);
        btnsave.addActionListener(new AddActionListener());
        panel.add(formalPanel, BorderLayout.WEST);
        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        new JdbcSwingCrudJava();
    }

    private class AddActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            int price = Integer.parseInt(priceField.getText());
            int quantity = Integer.parseInt(quantityField.getText());

            Object[] product = new Object[]{name, price, quantity};
            for (int i= 0; i<= product.length-1; i++){
                System.out.println(product[i].name);
            }

        }
    }
}
