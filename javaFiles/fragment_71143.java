if (position +1 < getItemCount() ) {
      if (!list.get(position).getProfession().substring(0, 1).equals
            (list.get(position + 1).getProfession().substring(0, 1))) {
          holder.view.setVisibility(View.VISIBLE);

      }
  }