<sjg:grid
    id="gridtable"
    caption="Example (Editable/Multiselect)"
    dataType="local"
    pager="true"
    navigator="true"
    navigatorSearchOptions="{sopt:['eq','ne','lt','gt']}"
    navigatorAddOptions="{height:280, width:500, reloadAfterSubmit:true}"
    navigatorEditOptions="{height:280, width:500, reloadAfterSubmit:false}"
    navigatorEdit="true"
    navigatorView="true"
    navigatorViewOptions="{height:280, width:500}"
    navigatorDelete="true"
    navigatorDeleteOptions="{height:280, width:500,reloadAfterSubmit:true}"
    gridModel="gridModel"
    rowList="5,10,15"
    rowNum="5"
    rownumbers="true"
    editurl="%{editurl}"
    editinline="true"
    multiselect="true"
    onSelectRowTopics="rowselect"
    >

    <sjg:gridColumn name="id" index="id" title="Id" formatter="integer" editable="false" sortable="true" search="true" sorttype="integer" searchoptions="{sopt:['eq','ne','lt','gt']}"/>
    <sjg:gridColumn name="name" index="name" key="true" title="Country Name" editable="true" edittype="text" sortable="true" search="true" sorttype="text"/>

</sjg:grid>
<script type="text/javascript">
  $(document).ready(function(){
    var mydata = [{id:"1",name:"Roman C"}];
    //for(var i=0;i<=mydata.length;i++) $("#gridtable").jqGrid('addRowData',i+1,mydata[i]);
    $("#gridtable").jqGrid('setGridParam', {
        data: mydata
    }).trigger("reloadGrid");
  });
</script>