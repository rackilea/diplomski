@Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                inputText = input.getText().toString();
                switch(v.getId()){
                    case R.id.finduppercase:
                        outputText = findUpperCase(inputText);
                        output.setText(outputText);
                        break;
                    case R.id.everyother:
                        outputText = everyOther(inputText);
                        output.setText(outputText);
                        break;
                    case R.id.vcount:
                    outputText=Integer.toString(vowelCount(inputText));
                    output.setText(outputText);
                        break;
                    case R.id.vpos:
                        outputText = vowelPositions(inputText);
                        output.setText(outputText);
                        break;
                    case R.id.vreplace:
                        outputText = vowelReplace(inputText);
                        output.setText(outputText);
                        break;
                }


        }