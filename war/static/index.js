$(function() {
    if (!goog) {
        return;
    }
    $.get("/createToken", function(token) {
        var channel = new goog.appengine.Channel(token);
        var conn = channel.open();
        conn.onmessage = function(e) {
            if (e.data[0] == "p") {
                var event = new Event("keydown");
                event.keyCode = 37;
                handleBodyKeyDown(event);
            } else if (e.data[0] == "n") {
                var event = new Event("keydown");
                event.keyCode = 39;
                handleBodyKeyDown(event);
            }
        };
    });
});
