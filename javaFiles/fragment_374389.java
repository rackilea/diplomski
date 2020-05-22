@Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            txtCurrent.setText(String.valueof(current));
            txtVoltage.setText(String.valueof(voltage));
        }