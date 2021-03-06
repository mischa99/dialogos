package com.clt.gui.table;

import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

/**
 * A checkbox which is displayed as disabled (grey) if the
 * field is not editable.
 */
public class CheckboxRenderer extends JCheckBox implements TableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected,
            boolean hasFocus, int row,
            int column) {

        if (value != null ? value instanceof Boolean : false) {
            this.setSelected(((Boolean) value).booleanValue());
        } else {
            this.setSelected(false);
        }
        this.setEnabled(table.isCellEditable(row, column));
        this.setHorizontalAlignment(SwingConstants.CENTER);

        if (isSelected) {
            this.setForeground(table.getSelectionForeground());
            this.setBackground(table.getSelectionBackground());
        } else {
            this.setForeground(table.getForeground());
            this.setBackground(table.getBackground());
        }
        return this;
    }
}
