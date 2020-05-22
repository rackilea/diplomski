function stripIfEmpty(html)
{
   var tmp = document.createElement("DIV");
   tmp.innerHTML = html;
   var contentText = tmp.textContent || tmp.innerText || "";
   if(contentText.trim().length === 0){
       return "";
   }else{
       return html;
   }
}