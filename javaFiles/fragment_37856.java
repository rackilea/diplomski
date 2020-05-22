LayoutInflater inflater = LayoutInflater.from(context);
View customToastView = inflater.inflate(R.layout.custom_toast, null);

TextView tvToast = (TextView) customToastView.findViewById(R.id.tvToast);
tvToast.setText("This is a custom toast with centered text");

Toast toast = new Toast(context);
toast.setView(customToastView);
toast.setDuration(Toast.LENGTH_SHORT);
toast.show();