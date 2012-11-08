var prev = function() {
    $.post("/sendMessage", {
        to: "all",
        data : "prev"
    })
};

var next = function() {
    $.post("/sendMessage", {
        to: "all",
        data : "next"
    })
};
