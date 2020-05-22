function getHTML(){
  var D=document,h=D.getElementsByTagName('html')[0],e;
  if(h.outerHTML)return h.outerHTML;
  e=D.createElement('div');
  e.appendChild(h.cloneNode(true));
  return e.innerHTML;
}