if (mFiltered != null) {
            resId = mFiltered.get(position);
            holder.logo.setImageResource(resId);
        } else {
            resId = drawables.get(position);
            holder.logo.setImageResource(resId);
        }