public String formatData(List<User> users) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < users.size(); i++) {
            stringBuilder.append("##\n");
            stringBuilder.append("id:" + user.getId() + "\n");
            stringBuilder.append("heatUsage:" + user.getHeatUsage() + "\n");
            stringBuilder.append("waterUsage:" + user.getWaterUsage() + "\n");
        }

        return stringBuilder.toString();
    }