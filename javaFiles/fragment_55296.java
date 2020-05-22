<form method="post" action="testOperation">
  <!-- I used only one hidden box to store value -->
  <input type="hidden" name="name" id="dynamicName">

    <input type="radio" name="tt" value="Insert"
        onclick="doDisplay(this);" /> Insert <span id="inserts"
        style="display: none"> <label for="Node"> Node </label> <input
        type="text" name="node" size="20" /> <label for="Data"> Data </label>
        <input type="text" name="data" size="100" />

    </span> <br /> <input type="radio" name="tt" value="Update"
        onclick="doDisplay(this);" /> Update <span id="updates"
        style="display: none"> <label for="Node"> Node </label> <input
        type="text" name="node" size="20" /> <label for="Data"> Data </label>
        <input type="text" name="data" size="100"/>

    </span> <br /> <input type="radio" name="tt" value="Delete"
        onclick="doDisplay(this);" /> Delete <span id="delete"
        style="display: none"> <label for="Node"> Node </label> <input
        type="text" name="node" size="20" /> <label for="Data"> Data </label>
        <input type="text" name="data" size="100"/>

    </span> <br />
    <input type="submit">
</form>