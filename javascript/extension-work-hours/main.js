/*jshint esversion: 6 */

function openSettings() {
   document.getElementById("settings").classList.toggle("settings-open"); 
}
document.getElementById("settings-button").addEventListener('click', openSettings);

var userName = localStorage.getItem('receivedName');
if (userName == null) {
   userName = "friend";
}

function changeName() {
   userName = document.getElementById("name-input").value;
   saveName();
   getGreeting();
}

document.getElementById("name-form").addEventListener('submit', function(e) {
   e.preventDefault();
   changeName();
   openSettings();
});

function saveName() {
   localStorage.setItem('receivedName', userName);
}

function getGreeting() {
   document.getElementById("greeting").innerHTML  = `Hello, ${userName}. Enjoy your day!`;
}
getGreeting();

function getDateTime() {
   var now     = new Date(); 
   var year    = now.getFullYear();
   var month   = now.getMonth()+1; 
   var day     = now.getDate();
   var hour    = now.getHours();
   var minute  = now.getMinutes();
   var second  = now.getSeconds(); 
   if(month.toString().length == 1) {
        month = '0'+month;
   }
   if(day.toString().length == 1) {
        day = '0'+day;
   }   
   if(hour.toString().length == 1) {
        hour = '0'+hour;
   }
   if(minute.toString().length == 1) {
        minute = '0'+minute;
   }
   if(second.toString().length == 1) {
        second = '0'+second;
   }   
   var dateTime = day+'/'+month+'/'+year+' '+hour+'h'+minute;   
    return dateTime;
}


function getData() {
   document.getElementById("clock").innerHTML = getDateTime();
}
getData();

