// int id = <some_value>;

return new Row(id, row_name.getText().toString(), object_type.getSelectedItem().toString(),
        rack_name.getText().toString(), tile_location.getText().toString(),
        tile_name.getText().toString(), direction.getSelectedItem().toString(),
        rotation.getSelectedItem().toString(), separation.getText().toString(),
        bf_offset.getText().toString());