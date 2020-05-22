<ui:style>
  .mypanel {
    width: 50px;
    height: 50px;
  }

  .myimg {
    width: 100%;
    height: 100%;
  }

  .mytext {
    font-weight: bold;
    color: green;
    font-size: 30px;
  }
</ui:style>

<g:LayoutPanel addStyleNames="{style.mypanel}">

  <g:layer>
    <g:Image url="my.png" addStyleNames="{style.myimg}"/>
  </g:layer>

  <g:layer>
    <g:Label addStyleNames="{style.mytext}">123</g:Label>
  </g:layer>

</g:LayoutPanel>