public class HolderUtilsTest {


@Test(expected = CancellationException.class)
public void testHolderParameterNulls(){
    HolderUtils.getServiceRequestDAO(null, null);
}

@Test(expected = CancellationException.class)
public void testHolderParameterHolderNull(){
    HolderUtils.getServiceRequestDAO(new ItemHolder.Builder().build(), null);
}


@Test
public void testHolderParameterNullAndSRNotNull(){
    final ServiceRequestDAO serviceRequestDAO = Mockito.spy(new ServiceRequestDAO());
    final ServiceRequestDAO serviceRequestDAO1 = HolderUtils.getServiceRequestDAO(new ItemHolder.Builder().build(), serviceRequestDAO);
    assertThat(serviceRequestDAO1).isNotNull();
    assertThat(serviceRequestDAO1).isEqualTo(serviceRequestDAO);
}


@Test
public void testHolderParameterNotNullWithObjectAndSRNull(){
    final ServiceRequestDAO serviceRequestDAO = Mockito.spy(new ServiceRequestDAO());
    final ServiceRequestDAO serviceRequestDAO1 = HolderUtils.getServiceRequestDAO(new ItemHolder.Builder().srDao(serviceRequestDAO).build(), null);
    assertThat(serviceRequestDAO1).isNotNull();
    assertThat(serviceRequestDAO1).isEqualTo(serviceRequestDAO);

}

@Test
public void testHolderBothPresent(){

    final ServiceRequestDAO serviceRequestDAO0 = Mockito.spy(new ServiceRequestDAO());
    final ServiceRequestDAO serviceRequestDAO1 = Mockito.spy(new ServiceRequestDAO());
    final ServiceRequestDAO serviceRequestDAOResult = HolderUtils.getServiceRequestDAO(new ItemHolder.Builder().srDao(serviceRequestDAO0).build(), serviceRequestDAO1);
    assertThat(serviceRequestDAOResult).isNotNull();
    assertThat(serviceRequestDAOResult).isEqualTo(serviceRequestDAO0);
    assertThat(serviceRequestDAOResult).isNotEqualTo(serviceRequestDAO1);


}