package org.example.Layout;

import lombok.Data;

import javax.swing.*;
import java.awt.*;

@Data
public class MainPageLayout {
    private JPanel jPanel;

    public MainPageLayout() {
        jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));

        TableLayout tableLayout =new TableLayout();
        FormLayout formLayout =new FormLayout(tableLayout);
        jPanel.add(formLayout.getFormPanel());
        jPanel.add(tableLayout.getTablePanel());

    }
}
