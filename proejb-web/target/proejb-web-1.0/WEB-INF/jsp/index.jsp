<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Project</title>


 <style>
*{ margin: 0px; padding:0px; }
.tablink {
    background-color: #555;
    color: white;
    float: left;
    border: none;
    outline: none;
    cursor: pointer;
    padding: 14px 16px;
    font-size: 17px;
    width: 25%;
}
.tablink:hover {
    background-color: #777;
}
.tabcontent {
    display: none;
    padding: 100px 20px;
    height: 100%;
}
#Home {background-color:  white;}
#News {background-color:  white;}
#Contact {background-color:  white;}
#About {background-color:  white;}

#server-response{
    margin: auto;
    padding: 3px;
    display: inline-flex;
    position: absolute;
    visibility: hidden;
    top: 80%;
    left: 88%;
    border: 1px solid gray;
    -webkit-box-shadow: -5px 4px 16px -1px rgba(0,0,0,0.75);
    -moz-box-shadow: -5px 4px 16px -1px rgba(0,0,0,0.75);
    box-shadow: -5px 4px 16px -1px rgba(0,0,0,0.75);
}
.button{
    color: white;
    width: 87px;
    height: 31px;
    background-color: crimson;
    border: 0px;
    box-shadow: -1px 1px 13px -5px rgba(0,0,0,0.75);
}

 </style>
</head>

<body>

<button class="tablink" onclick="openPage('Home', this, '#02475E')" id="defaultOpen">Company</button>
<button class="tablink" onclick="openPage('News', this, '#02475E')" >Users</button>
<button class="tablink" onclick="openPage('Contact', this, '#02475E')">Outgoing Message</button>
<button class="tablink" onclick="openPage('About', this, '#02475E')">Incoming Message</button>

<div id="Home" class="tabcontent">

    <h3>Company</h3>
    <br><br><br>
    <button  class="button" type="button" onclick="makePostRequest()"> Delete </button>



</div>

<div id="News" class="tabcontent">
    <h3>Users</h3>

</div>

<div id="Contact" class="tabcontent">
    <h3>Outgoing</h3>

</div>

<div id="About" class="tabcontent">
    <h3>Incoming</h3>

</div>

<h3 id="server-response" >
    <img src="${pageContext.request.contextPath}/assets/wait.gif"  height="70px" width="70px">
    <p style="margin:auto"> Waiting...</p>
</h3>




<script>
    var innerHtmlOfDiv =  document.getElementById("server-response").innerHTML;
    async function makePostRequest() {
        document.getElementById("server-response").style.visibility= "visible";
        var deleteUrl = "http://localhost:8080/web/delete";
        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", deleteUrl, true);
        xhttp.onload = function (e) {
            if (xhttp.readyState === 4) {
                document.getElementById("server-response").innerHTML = this.responseText;
                setTimeout(hideNotification, 2000);
            }
        };
        xhttp.send();
    }
    function hideNotification() {
        document.getElementById("server-response").style.visibility= "hidden";
        document.getElementById("server-response").innerHTML = innerHtmlOfDiv
    }

</script>


<script>
    function openPage(pageName,elmnt,color) {
        var i, tabcontent, tablinks;
        tabcontent = document.getElementsByClassName("tabcontent");
        for (i = 0; i < tabcontent.length; i++) {
            tabcontent[i].style.display = "none";
        }
        tablinks = document.getElementsByClassName("tablink");
        for (i = 0; i < tablinks.length; i++) {
            tablinks[i].style.backgroundColor = "";
        }
        document.getElementById(pageName).style.display = "block";
        elmnt.style.backgroundColor = color;
    }

    // Get the element with id="defaultOpen" and click on it
    document.getElementById("defaultOpen").click();
</script>

</body>
</html>