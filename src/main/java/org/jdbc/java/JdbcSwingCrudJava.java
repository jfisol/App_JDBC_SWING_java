package org.jdbc.java;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class JdbcSwingCrudJava extends JFrame {

    private JTextField nameField = new JTextField();
    private JTextField priceField = new JTextField();

    private JTextField quantityField = new JTextField();

    private ProductTableModel productModel = new ProductTableModel();

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

        JPanel panelTable = new JPanel(new FlowLayout());

        JTable jtable = new JTable();
        jtable.setModel(this.productModel);

        JScrollPane scroll = new JScrollPane(jtable);
        panelTable.add(scroll);



        panel.add(panelTable, BorderLayout.SOUTH);
        panel.add(formalPanel, BorderLayout.NORTH);
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
            productModel.getRows().add(product);
            productModel.fireTableDataChanged(); //Actualize la data

            nameField.setText("");
            priceField.setText("");
            quantityField.setText("");

        }
    }

    public class ProductTableModel extends AbstractTableModel{

        private String[] columns = new String[]{"Nombre", "Precio" , "Cantidad"};
        private List<Object[]> rows;

        ProductTableModel (){
            rows = new ArrayList<>();
        }

        public List<Object[]> getRows() {
            return rows;
        }

        @Override
        public int getRowCount() {
            return rows.size();
        }

        @Override
        public int getColumnCount() {
            return columns.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return rows.get(rowIndex)[columnIndex];
        }

        @Override
        public String getColumnName(int column) {
            return columns[column];
        }
    }
}
