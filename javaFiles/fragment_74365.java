package com.remindme.sayem.remindme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ItemEditorActivity extends AppCompatActivity implements View.OnClickListener{

EditText itemEditorEditText;
Button doneButton;
Button addDataButton;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_item_editor);
    itemEditorEditText = (EditText) findViewById(R.id.itemEditorEditText);
    doneButton = (Button) findViewById(R.id.doneButton);
    addDataButton = (Button) findViewById(R.id.addDataButton);
    addDataButton.setOnClickListener(this);
    doneButton.setOnClickListener(this);

}

@Override
protected void onPause() {
    super.onPause();
    finish();
}

@Override
public void onClick(View v) {
    switch (v.getId()){
        case R.id.addDataButton:
            ItemListDatabase itemListDatabase = new ItemListDatabase(this);
            String itemEditorString = itemEditorEditText.getText().toString();
            ItemNameClass itemNameClass = new ItemNameClass(itemEditorString);
            String group_position = getIntent().getStringExtra("GROUP_POSITION");
            if (group_position.equals("Pharmacy"))
            {
                itemListDatabase.insertDataIntoPharmacy(itemNameClass);
                Toast.makeText(getApplicationContext(), "Added to " + group_position, Toast.LENGTH_LONG).show();
                itemEditorEditText.setText("");
            }
            else if (group_position.equals("Super Shop")) {

                itemListDatabase.insertDataIntoSuperShop(itemNameClass);
                Toast.makeText(getApplicationContext(), "Added to " + group_position, Toast.LENGTH_LONG).show();
                itemEditorEditText.setText("");
            }
            else if (group_position.equals("Stationery Shop")) {

                itemListDatabase.insertDataIntoStationeryShop(itemNameClass);
                Toast.makeText(getApplicationContext(), "Added to " + group_position, Toast.LENGTH_LONG).show();
                itemEditorEditText.setText("");
            }
            else if (group_position.equals("Market")) {

                itemListDatabase.insertDataIntoMarket(itemNameClass);
                Toast.makeText(getApplicationContext(), "Added to " + group_position, Toast.LENGTH_LONG).show();
                itemEditorEditText.setText("");
            }
            else if (group_position.equals("Hotel")) {

                itemListDatabase.insertDataIntoHotel(itemNameClass);
                Toast.makeText(getApplicationContext(), "Added to " + group_position, Toast.LENGTH_LONG).show();
                itemEditorEditText.setText("");
            }
            else if (group_position.equals("Hardware Shop")) {

                itemListDatabase.insertDataIntoHardwareShop(itemNameClass);
                Toast.makeText(getApplicationContext(), "Added to " + group_position, Toast.LENGTH_LONG).show();
                itemEditorEditText.setText("");
            }
            else if (group_position.equals("Computer Accessories Shop")){

                itemListDatabase.insertDataIntoComputerAccessoriesShop(itemNameClass);
                Toast.makeText(getApplicationContext(), "Added to " + group_position, Toast.LENGTH_LONG).show();
                itemEditorEditText.setText("");
            }
            break;

        case R.id.doneButton:
            Intent intent = new Intent(ItemEditorActivity.this, CategoryList.class);
            startActivity(intent);
            break;
    }
}
}