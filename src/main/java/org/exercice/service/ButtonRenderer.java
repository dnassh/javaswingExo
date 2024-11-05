package org.exercice.service;


import com.kitfox.svg.app.beans.SVGIcon;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class ButtonRenderer extends JPanel implements TableCellRenderer {
    private final JButton btnEdit = new JButton("Edit");
    private final JButton btnDelete = new JButton("Del");

    public ButtonRenderer() {

        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        btnEdit.setPreferredSize(new Dimension(60,20));
        btnDelete.setPreferredSize(new Dimension(60,20));
        add(btnEdit);
        add(btnDelete);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column) {
        if (isSelected) {
            this.setBackground(table.getSelectionBackground());
            btnEdit.setBackground(table.getSelectionBackground());
            btnDelete.setBackground(table.getSelectionBackground());
        } else {
            this.setBackground(table.getBackground());
            btnEdit.setBackground(new Color(30,135,230));
        }
        return this;
    }
}