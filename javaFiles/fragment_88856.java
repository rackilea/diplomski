customersList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                if (customersList.getAdapter() == adapter) {

                    String[] invoice =(String[]) parent.getAdapter().getItem(position);
                    switch (invoice[6]){

                        case "Payment":
                            Intent approvalDetailsIntent1 = new Intent(previous.this,PpaymentDetails.class);
                            approvalDetailsIntent1.putExtra(Common.APPROVALID,invoice[0]);
                            approvalDetailsIntent1.putExtra(Common.ENTRYNO, invoice[1]);
                            approvalDetailsIntent1.putExtra(Common.PAYMENT_MODE, invoice[4]);
                            approvalDetailsIntent1.putExtra(Common.PAYMENT_DATE, invoice[3]);
                            approvalDetailsIntent1.putExtra(Common.AMOUNT, invoice[5]);
                            approvalDetailsIntent1.putExtra(Common.COMPANY_DETAILS, invoice[2]);
                            approvalDetailsIntent1.putExtra(Common.GENERAL_NOTES,invoice[8]);
                            approvalDetailsIntent1.putExtra(Common.PAYMENT_TYPE, invoice[6]);
                            startActivity(approvalDetailsIntent1);


                            break;

                        case "Expense":

                            Intent approvalDetailsIntent2 = new Intent(previous.this, PexpenseDetail.class);
                            approvalDetailsIntent2.putExtra(Common.APPROVALID, invoice[0]);
                            approvalDetailsIntent2.putExtra(Common.REFNO, invoice[1]);
                            startActivity(approvalDetailsIntent2);


                            break;


                    }

//                                    Common.toastMessage(getContext(), "scene aan");
                }

                else if (customersList.getAdapter() == Padapter) {
                    String[] payment =(String[]) parent.getAdapter().getItem(position);
                    Intent approvalDetailsIntent1 = new Intent(previous.this,PpaymentDetails.class);
                    approvalDetailsIntent1.putExtra(Common.APPROVALID, payment[0]);
                    approvalDetailsIntent1.putExtra(Common.ENTRYNO, payment[1]);
                    approvalDetailsIntent1.putExtra(Common.PAYMENT_MODE, payment[4]);
                    approvalDetailsIntent1.putExtra(Common.PAYMENT_DATE, payment[3]);
                    approvalDetailsIntent1.putExtra(Common.AMOUNT, payment[5]);
                    approvalDetailsIntent1.putExtra(Common.COMPANY_DETAILS, payment[2]);
                    approvalDetailsIntent1.putExtra(Common.GENERAL_NOTES, payment[8]);
                    approvalDetailsIntent1.putExtra(Common.PAYMENT_TYPE, payment[6]);
                    startActivity(approvalDetailsIntent1);


                }
                else if (customersList.getAdapter() == Eadapter) {

                    String[] pExpence =(String[]) parent.getAdapter().getItem(position);
                    Intent approvalDetailsIntent2 = new Intent(previous.this, PexpenseDetail.class);
                    approvalDetailsIntent2.putExtra(Common.APPROVALID, pExpence[0]);
                    approvalDetailsIntent2.putExtra(Common.REFNO, pExpence[1]);
                    startActivity(approvalDetailsIntent2);
                }


            }
        });