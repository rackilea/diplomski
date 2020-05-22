Public OrderEntity getOrderEntity(orderQueryParam, boolean loadConsumerEntity){
    Sting hql = buildHqlStrFromParam(orderQueryParam);
    OrderEntity entity = this.getEntityByHql(hql);
    if(loadConsumerEntity){
      // Your session shoud still open here
      entity.getConsumerEntity();
    }
    return entity; 
}