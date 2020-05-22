package dpw.client;

import java.util.ArrayList;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.PageSizePager;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.cellview.client.Header;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.view.client.ListViewAdapter;

public class Index implements EntryPoint {

    public void onModuleLoad() {

        // create some data
        ArrayList<String> values = new ArrayList<String>();
        values.add("one");
        values.add("two");
        values.add("three");
        values.add("four");
        values.add("five");
        values.add("six");

        // create a ListViewAdapter
        ListViewAdapter<String> lva = new ListViewAdapter<String>();
        // give the ListViewAdapter our data
        lva.setList(values);

        {
            // CellList of TextCells with PageSizePager
            CellList<String> cl = new CellList<String>(new TextCell());
            // set the initial pagesize to 2
            cl.setPageSize(2);

            // add the CellLists to the adaptor
            lva.addView(cl);

            // create a PageSizePager, giving it a handle to the CellList
            PageSizePager<String> psp = new PageSizePager<String>(cl, 2);

            // add the CellList to the page
            RootPanel.get().add(cl);

            // add the PageSizePager to the page
            RootPanel.get().add(psp);
        }

        RootPanel.get().add(new HTML("<hr />"));

        {
            // CellList of TextCells with a SimplePager
            CellList<String> cl = new CellList<String>(new TextCell());
            // set the initial pageSize to 2
            cl.setPageSize(2);

            // add the CellLists to the adaptor
            lva.addView(cl);

            // create a pager, giving it a handle to the CellList
            SimplePager<String> pager = new SimplePager<String>(cl,
                    SimplePager.TextLocation.CENTER);

            // add the CellList to the page
            RootPanel.get().add(cl);

            // add the Pager to the page
            RootPanel.get().add(pager);
        }

        RootPanel.get().add(new HTML("<hr />"));

        {
            // CellList of TextCells with a SimplePager and PageSizePager
            CellList<String> cl = new CellList<String>(new TextCell());
            // set the initial pageSize to 2
            cl.setPageSize(2);

            // add the CellLists to the adaptor
            lva.addView(cl);

            // create a PageSizePager, giving it a handle to the CellList
            PageSizePager<String> psp = new PageSizePager<String>(cl, 1);

            // create a pager, giving it a handle to the CellList
            SimplePager<String> pager = new SimplePager<String>(cl,
                    SimplePager.TextLocation.CENTER);

            // add the CellList to the page
            RootPanel.get().add(cl);

            // add the Pager to the page
            RootPanel.get().add(pager);

            // add the PageSizePager to the page
            RootPanel.get().add(psp);
        }

        RootPanel.get().add(new HTML("<hr />"));

        {
            // CellTable
            CellTable<String> ct = new CellTable<String>();
            ct.setPageSize(2);
            lva.addView(ct);

            // add a column with a simple string header
        ct.addColumn(new TextColumn<String>() {

            @Override
            public String getValue(String object) {
                return object;
            }
        }, "String Header");

        //add a column with a TextCell header
        ct.addColumn(new TextColumn<String>() {

            @Override
            public String getValue(String object) {
                return "%" + object + "%";
            }
        }, new Header<String>(new TextCell()) {

            @Override
            public String getValue() {
                return "TextCell Header";
            }
        });

            // create a pager, giving it a handle to the CellTable
            SimplePager<String> pager = new SimplePager<String>(ct,
                    SimplePager.TextLocation.CENTER);

            // add the CellList to the page
            RootPanel.get().add(ct);

            // add the Pager to the page
            RootPanel.get().add(pager);
        }
    }
}