package org.exercice.service;

import org.exercice.model.Spectacle;
import org.exercice.model.SpectacleTable;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import java.util.List;

public class ButtonEditor extends AbstractCellEditor implements TableCellEditor {
    private final JPanel panel = new JPanel();
    private final JButton btnEdit = new JButton("Modifier");
    private final JButton btnDelete = new JButton("Supprimer");

    public ButtonEditor(JTable table, List<Spectacle> spectacles, SpectacleTable model) {
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
        panel.add(btnEdit);
        panel.add(btnDelete);

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                Spectacle spectacle = spectacles.get(row);
                JOptionPane.showMessageDialog(table, "Modifier : " + spectacle.getDescription());
                fireEditingStopped();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                spectacles.remove(row);
                model.fireTableRowsDeleted(row, row);
                fireEditingStopped();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }

    @Override
    public boolean isCellEditable(EventObject e) {
        return true;
    }
}

