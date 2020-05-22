if (dataone.size() > 0) {
                for (int i = 0; i < dataone.size(); i++) {

                    boolean flag = false;
                    for (int j = 0; j < datas.size(); j++) {
                        if (datas.get(j).getName().equals(dataone.get(i).getName())) {
                            flag = true;
                            datas.get(j).setPrice(datas.get(j).getPrice() + dataone.get(i).getPrice());
                            break;
                        } else {
                            flag = false;

                        }
                    }
                    if (!flag) {
                        datas.add(dataone.get(i));
                    }
                }
            }