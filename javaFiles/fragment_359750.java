private List<Item> data;
//getter and setter

public String doData() {
  data = getData(qString);
  ...
  return Action.SUCCESS;
}

<action name="DummyDB" class="com.shopping.op.welcome.DummyDB" method="doData">
 <result>/jsp/whateveryoudo.jsp</result>
</action>