/*
 * Copyright 2013 Japplis.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 * The JTable used to display data.
 * This class is only to fix bugs or improve existing functionalities.
 *
 * @author Anthony Goubard - Japplis
 */
public class SheetTable extends JTable {

    private Map<Integer, Set<Integer>> selectedCells = new HashMap<>();
    private Point firstExtendCell;

    public SheetTable(TableModel tableModel) {
        super(tableModel);
    }

    @Override
    public void changeSelection(int rowIndex, int columnIndex, boolean toggle, boolean extend) {
        if (toggle && isCellSelected(rowIndex, columnIndex) && !extend) {
            selectedCells.get(rowIndex).remove(columnIndex);
        } else {
            if (!toggle && !extend) {
                selectedCells.clear();
            }
            Set<Integer> selectedColumns = selectedCells.get(rowIndex);
            if (selectedColumns == null) {
                selectedColumns = new TreeSet<>();
                selectedCells.put(rowIndex, selectedColumns);
            }
            selectedColumns.add(columnIndex);
            if (!extend) {
                firstExtendCell = new Point(rowIndex, columnIndex);
            } else {
                for (int i = Math.min(firstExtendCell.x, rowIndex); i <= Math.max(firstExtendCell.x, rowIndex); i++) {
                    for (int j = Math.min(firstExtendCell.y, columnIndex); j <= Math.max(firstExtendCell.y, columnIndex); j++) {
                        selectedCells.get(i).add(j);
                    }
                }
            }
        }
        super.changeSelection(rowIndex, columnIndex, toggle, extend);
    }

    @Override
    public void addRowSelectionInterval(int index0, int index1) {
        for (int i = index0; i < index1; i++) {
            selectedCells.remove(i);
        }
        super.addRowSelectionInterval(index0, index1);
    }

    @Override
    public void removeRowSelectionInterval(int index0, int index1) {
        for (int i = index0; i < index1; i++) {
            selectedCells.remove(i);
        }
        super.removeRowSelectionInterval(index0, index1);
    }

    @Override
    public void selectAll() {
        selectedCells.clear();
        super.selectAll();
    }

    @Override
    public void clearSelection() {
        if (selectedCells != null) {
            selectedCells.clear();
        }
        super.clearSelection();
    }

    @Override
    public boolean isCellSelected(int row, int column) {
        if (!getSelectionModel().isSelectedIndex(row)) {
            return false;
        }
        if (getSelectionModel().isSelectedIndex(row) && selectedCells.get(row) == null) {
            return true;
        }
        return selectedCells.get(row).contains(column);
    }
}