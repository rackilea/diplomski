<?php
$searchString = "/res/";
$foundString = "some text restaurant and other";
$explode = explode(" ", $foundString);
$searched = preg_grep($searchString, $explode);

foreach($searched as $item) {
  echo $item . " ";
}