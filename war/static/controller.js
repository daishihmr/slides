var prev = function() {
    $.post("/sendMessage", {
        data : "prev"
    })
};

var next = function() {
    $.post("/sendMessage", {
        data : "next"
    })
};
