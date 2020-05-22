public static double buyVideo()
{
    Scanner typeNumber = new Scanner(System.in);
    String title = typeNumber.nextLine();
    String amount = null;
    for (int i = 0; i < VTable.size(); i++) {
        String videoDetails = VTable.get(i).toString();

        if (videoDetails.toLowerCase().contains(title.toLowerCase())) {
            Basket.add(VTable.get(i));
            for (int j = videoDetails.length() - 2; j >= 0; j--) {
                if (videoDetails.charAt(j) == ' ') {
                    break;
                }
                amount = videoDetails.substring(j,
                        videoDetails.length() - 1);

            }

            // ** ADD LINE TO INDICATE ACTION
            System.out.println("Purchasing: " + VTable.remove(i).getTitle());
        }

    }
    // ** CHANGE TO USE A LOCAL VARIABLE AND RETURN IT
    double videoRentCost = Double.parseDouble(amount);

    return videoRentCost;
}