package org.exercice.model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class SpectacleTable extends AbstractTableModel {
    private final List<Spectacle> spectacles;
    private final String[] columnNames = {"Numéro", "Description", "Nre Billets", "Billets disponibles", "Prix","Actions"};

    public SpectacleTable(List<Spectacle> spectacles) {
        this.spectacles = spectacles;
    }

    @Override
    public int getRowCount() {
        return spectacles.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Spectacle spectacle = spectacles.get(rowIndex);
        switch (columnIndex) {
            case 0: return spectacle.getNumber();
            case 1: return spectacle.getDescription();
            case 2: return spectacle.getNbrBillets();
            case 3: return spectacle.getBilletsDispos();
            case 4: return spectacle.getPrice();
            case 5: return "Actions";
            default: return null;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 5;
    }
}
