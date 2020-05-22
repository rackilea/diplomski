loginBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            SharedPreferences prefs = getSharedPreferences("WidgetPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("msg_" + widgetId, nameInput.getText().toString()); //???
            editor.commit();

            //Actualizar el widget tras la config
            System.out.println("[INFO] Getting instance of WidgetConfig");
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(WidgetConfig.this);
            System.out.println("[INFO] Updating the widget");
            FerrixWidget.updateAppWidget(WidgetConfig.this, appWidgetManager, widgetId);


            //Devolver un buen OK
            Intent resultado = new Intent();
            resultado.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetId);
            //System.out.println("[CONFIG INFO] Name text is: " + nameInput.getText().toString());
            resultado.putExtra("Name", nameInput.getText().toString());
            resultado.setAction("myUpdate");
            ComponentName componentName = new ComponentName(getApplicationContext(), FerrixWidget.class);
            resultado.setComponent(componentName);
            sendBroadcast(resultado);

            setResult(RESULT_OK, getIntent());
            finish();
            System.out.println("[INFO] OK devuelto!");
        }
 });