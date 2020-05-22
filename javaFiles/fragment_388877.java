TextView tvPotential;
        TextView tvAddress;
        TextView tvDateofShoot;




        tvPotential = (TextView) convertView.findViewById(R.id.tvPotential);
        tvAddress = (TextView) convertView.findViewById(R.id.tvAddress);
        tvDateofShoot = (TextView)convertView.findViewById(R.id.tvDateofShoot);

        StringBuffer potentialBuffer = new StringBuffer();
        for(Photoshoots.potentialDetails details : photoshootsscheduleList.get(position).getPotentialDetails()){
            potentialBuffer.append(details.getPotentialName() + "\n");
          }
        StringBuffer addressBuffer = new StringBuffer();
        for(Photoshoots.addressDetails details : photoshootsscheduleList.get(position).getAddressDetails()){
            addressBuffer.append(details.getAddress() + "\n");
        }
        StringBuffer dateBuffer = new StringBuffer();
        for(Photoshoots.dateDetails details : photoshootsscheduleList.get(position).getDateDetails()){
            dateBuffer.append(details.getDateofShoot());
        }
        final StringBuffer potentialIDBuffer = new StringBuffer();
        for(Photoshoots.PotentialIDDetails details : photoshootsscheduleList.get(position).getPotentialIDDetails()){
            potentialIDBuffer.append(details.getPotentialIDDetails());
        }


        tvPotential.setText(potentialBuffer.toString());
        tvAddress.setText(addressBuffer.toString());
        tvDateofShoot.setText(dateBuffer.toString());