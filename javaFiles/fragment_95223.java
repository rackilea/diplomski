public class VoyageInformationAdapter extends RecyclerView.Adapter {
private String i;

                    if (i != null && i.equals("1")){
                        viewHolderBus.textV_from_city.setText(leg.getTo_city());
                        viewHolderBus.textV_to_city.setText(leg.getFrom_city());
                    }else{
                    viewHolderBus.textV_from_city.setText(leg.getFrom_city());
                    viewHolderBus.textV_to_city.setText(leg.getTo_city());
                    i = "1";
                   }}