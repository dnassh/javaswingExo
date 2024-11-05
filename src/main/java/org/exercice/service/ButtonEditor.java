package org.exercice.service;

import org.exercice.model.Spectacle;
import org.exercice.model.SpectacleTable;
import org.exercice.view.SpectacleFormView;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import java.util.List;

public class ButtonEditor extends AbstractCellEditor implements TableCellEditor {
    private final JPanel panel = new JPanel();
    private final JButton btnEdit = new JButton("Edit");
    private final JButton btnDelete = new JButton("Del");

    public ButtonEditor(JTable table, List<Spectacle> spectacles, SpectacleTable model) {
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        btnEdit.setPreferredSize(new Dimension(60,20));
        btnDelete.setPreferredSize(new Dimension(60,20));
        panel.add(btnEdit);
        panel.add(btnDelete);

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                Spectacle spectacle = spectacles.get(table.convertRowIndexToModel(row));
////                Spectacle spectacle = spectacles.get(row);
//                Spectacle spectacle = new Spectacle();
//                spectacle.setDescription("Une description");
                System.out.println(spectacle);
                JDialog content = new SpectacleFormView((JFrame) table.getTopLevelAncestor(),spectacle);
                content.setLocationRelativeTo(table.getTopLevelAncestor());
                content.setVisible(true);
                fireEditingStopped();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                int confirmation = JOptionPane.showConfirmDialog(null,"supprimer ?");
                if (confirmation == 0){
                spectacles.remove(row);
                model.fireTableRowsDeleted(row, row);
                }
                fireEditingStopped();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (isSelected) {
            panel.setBackground(table.getSelectionBackground());
            btnEdit.setBackground(table.getSelectionBackground());
            btnDelete.setBackground(table.getSelectionBackground());
        } else {
            panel.setBackground(table.getBackground());
            btnEdit.setBackground(new Color(30,135,230));
        }
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

