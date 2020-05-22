@Rollback(false)
       @Test
       public void testGetDeviceListItemList() {
          Device device = new Device();
          this.sessionFactory.getCurrentSession().merge(device);

          Query myQuery = this.sessionFactory.getCurrentSession().createQuery("from DeviceListItem");
          List<DeviceListItem> allDeviceListItems = myQuery.list();
          assertTrue(allDeviceListItems.get(0).getId().equals(device.getId());

          this.sessionFactory.getCurrentSession().delete(device);
      }