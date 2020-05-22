public boolean isSelected(Integer userId){
        if (userId != null) {
            return userId.equals(id);
        }
        return false;
    }