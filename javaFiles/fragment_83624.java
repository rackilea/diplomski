function showMessage(){

document.getElementById('msg_id').style.display = "inline";

setTimeout ( "misAndClick()", 10000);
}

function misAndClick(){
document.getElementById('msg_id').style.display = "hidden";
document.getElementById('buttonToNextAction').click();

}