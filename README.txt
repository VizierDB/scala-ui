Mostly notes for now... see back later for an actual README

## Websockets Docs
- https://javascript.info/websocket

```
let socket = new WebSocket("wss://javascript.info/article/websocket/demo/hello");

socket.onopen = function(e) {
  alert("[open] Connection established");
  alert("Sending to server");
  socket.send("My name is John");
};

socket.onmessage = function(event) {
  alert(`[message] Data received from server: ${event.data}`);
};

socket.onclose = function(event) {
  if (event.wasClean) {
    alert(`[close] Connection closed cleanly, code=${event.code} reason=${event.reason}`);
  } else {
    // e.g. server process killed or network down
    // event.code is usually 1006 in this case
    alert('[close] Connection died');
  }
};

socket.onerror = function(error) {
  alert(`[error] ${error.message}`);
};
```

## Mill 
- http://com-lihaoyi.github.io/mill

## ScalaJS
- http://www.scala-js.org/
- https://www.lihaoyi.com/hands-on-scala-js/

## Scala.RX
- https://github.com/lihaoyi/scala.rx
