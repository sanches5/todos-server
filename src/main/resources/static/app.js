var stompClient = null;
let user = {
    login: "BOB",
    id: 1
}

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/listener/user', function (greeting) {
            console.log("greeting", greeting)
            showGreeting(JSON.parse(greeting.body));
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
}

function createTask() {
    stompClient.send("/app/tasks/create", {}, JSON.stringify(
        {
            'id': user.id,
            "title": $("#name").val() || "default",
            "description": $("#description").val() || "default"
        }));
}




function showGreeting(message) {
    console.log("message", message)
    $("#greetings").append("<tr><td>" + message.title +" " +  message.description +" " + message.completed +" " + message.id + "<button id='test' onclick='createTask()'>delete</button>" + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { createTask(); });
});
