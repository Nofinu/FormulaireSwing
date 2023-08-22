package org.example.Layout;

import lombok.Data;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Data
public class FormLayout {
    private JPanel formPanel;

    private Container c;
    private JLabel name;
    private JTextField tName;
    private JLabel email;
    private JTextField tEmail;
    private JLabel gender;
    private JRadioButton male;
    private JRadioButton female;
    private ButtonGroup gengp;

    private JButton submit;

    private TableLayout tableLayout;

    public FormLayout(TableLayout tableLayout){
        this.tableLayout =tableLayout;
        formPanel = new JPanel();
        formPanel.setMaximumSize(new Dimension(1080,300));
        formPanel.setLayout(new BorderLayout());
        formPanel.setVisible(true);
        //formPanel.setLayout(new BoxLayout(formPanel,BoxLayout.Y_AXIS));
        Border borderTitle = BorderFactory.createTitledBorder("Formulaire d'ajout");
        formPanel.setBorder(borderTitle);

        c = new Container();

        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(100, 100);
        c.add(name);

        tName = new JTextField();
        tName.setFont(new Font("Arial", Font.PLAIN, 15));
        tName.setSize(190, 20);
        tName.setLocation(200, 100);
        c.add(tName);

        email = new JLabel("Email");
        email.setFont(new Font("Arial", Font.PLAIN, 20));
        email.setSize(100, 20);
        email.setLocation(100, 150);
        c.add(email);

        tEmail = new JTextField();
        tEmail.setFont(new Font("Arial", Font.PLAIN, 15));
        tEmail.setSize(150, 20);
        tEmail.setLocation(200, 150);
        c.add(tEmail);

        gender = new JLabel("Gender");
        gender.setFont(new Font("Arial", Font.PLAIN, 20));
        gender.setSize(100, 20);
        gender.setLocation(100, 200);
        c.add(gender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Arial", Font.PLAIN, 15));
        male.setSelected(true);
        male.setSize(75, 20);
        male.setLocation(200, 200);
        c.add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Arial", Font.PLAIN, 15));
        female.setSelected(false);
        female.setSize(80, 20);
        female.setLocation(275, 200);
        c.add(female);

        gengp = new ButtonGroup();
        gengp.add(male);
        gengp.add(female);



        submit = new JButton("Submit");
        submit.setFont(new Font("Arial", Font.PLAIN, 15));
        submit.setSize(150, 20);
        submit.setLocation(200, 250);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String genderSelect;
                if(male.isSelected()){
                    genderSelect = "Male";
                }
                else {
                    genderSelect = "Female";
                }
                tableLayout.addPersonne(tName.getText(),tEmail.getText(),genderSelect);
            }
        });
        c.add(submit);
        formPanel.add(c,BorderLayout.CENTER);

    }
}
