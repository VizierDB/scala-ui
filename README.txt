# Scala-UI

A ScalaJS implementation of the Vizier UI [Very much a WIP]

## Set Up

Requirements:
* [Mill](https://github.com/com-lihaoyi/mill#documentation)
* [VizierScala v1.1](https://github.com/VizierDB/vizier-scala/tree/v1.1) (still in prerelease)

## Build and run

Start Vizier
```
cd vizier-scala
sbt run -- --connect-from-any-host
```

Compile and run the UI
```
cd scala-ui
mill ui.fastOpt
```
and then open `index.html`

## Project Status

This is currently a proof-of-concept.  There is not much of a UI implemented yet, and most parameters are hardcoded.

In its current state, the program creates a websocket connection to ProjectID=1, BranchID=1 and monitors its state in realtime.  Nudging project state needs to happen through API calls, none of which have friendly wrappers implemented at this time.  The hardcoded project/branch ID can be replaced [here](https://github.com/VizierDB/scala-ui/blob/main/ui/src/info/vizierdb/ui/WebApp.scala).

The main components:
* [The outer UI](https://github.com/VizierDB/scala-ui/blob/main/index.html)
* [UI for the different project elements](https://github.com/VizierDB/scala-ui/tree/main/ui/src/info/vizierdb/ui/view)
* [The magic for not re-rendering DOM nodes as lists change](https://github.com/VizierDB/scala-ui/blob/main/ui/src/info/vizierdb/ui/rxExtras/RxBufferView.scala)



# Notes to Self

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
