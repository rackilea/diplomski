public class UIDOrg {

        public String org;
        public Timestamp lastEdit;
        public String rootCollection;
        public Boolean userRoleDelivery, userRoleFulfilment, userRoleOrder, userRoleVerification, allowEditOrder, allowAddOrder;
        public Long localNotificationReminderTime;

    public UIDOrg() {
    }

    public UIDOrg(String org, Timestamp lastEdit, String rootCollection, Boolean userRoleDelivery, Boolean userRoleFulfilment, Boolean userRoleOrder, Boolean userRoleVerification, Boolean allowEditOrder, Boolean allowAddOrder, Long localNotificationReminderTime) {
        this.org = org;
        this.lastEdit = lastEdit;
        this.rootCollection = rootCollection;
        this.userRoleDelivery = userRoleDelivery;
        this.userRoleFulfilment = userRoleFulfilment;
        this.userRoleOrder = userRoleOrder;
        this.userRoleVerification = userRoleVerification;
        this.allowEditOrder = allowEditOrder;
        this.allowAddOrder = allowAddOrder;
        this.localNotificationReminderTime = localNotificationReminderTime;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public Timestamp getLastEdit() {
        return lastEdit;
    }

    public void setLastEdit(Timestamp lastEdit) {
        this.lastEdit = lastEdit;
    }

    public String getRootCollection() {
        return rootCollection;
    }

    public void setRootCollection(String rootCollection) {
        this.rootCollection = rootCollection;
    }

    public Boolean getUserRoleDelivery() {
        return userRoleDelivery;
    }

    public void setUserRoleDelivery(Boolean userRoleDelivery) {
        this.userRoleDelivery = userRoleDelivery;
    }

    public Boolean getUserRoleVerification() {
        return userRoleVerification;
    }

    public void setUserRoleVerification(Boolean userRoleVerification) {
        this.userRoleVerification = userRoleVerification;
    }

    public Boolean getAllowAddOrder() {
        return allowAddOrder;
    }

    public void setAllowAddOrder(Boolean allowAddOrder) {
        this.allowAddOrder = allowAddOrder;
    }

    public Long getLocalNotificationReminderTime() {
        return localNotificationReminderTime;
    }

    public void setLocalNotificationReminderTime(Long localNotificationReminderTime) {
        this.localNotificationReminderTime = localNotificationReminderTime;
    }

    public Boolean getAllowEditOrder() {
        return allowEditOrder;
    }

    public void setAllowEditOrder(Boolean allowEditOrder) {
        this.allowEditOrder = allowEditOrder;
    }

    public Boolean getUserRoleFulfilment() {
        return userRoleFulfilment;
    }

    public void setUserRoleFulfilment(Boolean userRoleFulfilment) {
        this.userRoleFulfilment = userRoleFulfilment;
    }

    public Boolean getUserRoleOrder() {
        return userRoleOrder;
    }

    public void setUserRoleOrder(Boolean userRoleOrder) {
        this.userRoleOrder = userRoleOrder;
    }
}