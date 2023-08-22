package org.example.Layout;

import lombok.Data;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Data
public class TableLayout {
    private JPanel tablePanel;
    private Container c;

    private static String[] columnNames = {"Name","Email","Gender"};
    private DefaultTableModel dtm = new DefaultTableModel(null, columnNames) {

        @Override
        public Class<?> getColumnClass(int col) {
            return getValueAt(0, col).getClass();
        }
    };

    private FormLayout formLayout;

    public TableLayout() {
        tablePanel = new JPanel();
        tablePanel.setLayout(new BoxLayout(tablePanel,BoxLayout.Y_AXIS));
        Border borderTitle = BorderFactory.createTitledBorder("Tableau des données");
        tablePanel.setBorder(borderTitle);

        JTable table = new JTable(dtm);

        tablePanel.add(table);

        JButton detail = new JButton("detail");
        detail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int rowSelected = table.getSelectedRow();
               String name =(String) table.getValueAt(rowSelected,0);
               String email = (String) table.getValueAt(rowSelected,1);
               String gender = (String) table.getValueAt(rowSelected,2);
               JOptionPane.showMessageDialog(tablePanel,"Name : "+name+"\n"+"Email : "+email+"\n"+"Gender : "+gender);
            }
        });
        tablePanel.add(detail);

        dtm.addRow(new Object[]{
                "Name",
                "Email",
                "Gender"
        });

    }

    public void addPersonne (String name, String email,String gender){
        dtm.addRow(new Object[]{
                name,
                email,
                gender
        });


    }
}
