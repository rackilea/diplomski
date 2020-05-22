protected FilterResults performFiltering(CharSequence prefix) {
            return pFilter.performFiltering(prefix == null ? null :
              sParent.normaliseAcronym(prefix.toString()));
        }
    }
}