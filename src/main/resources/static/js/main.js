
function data_create() {
    alert("C")

    let name = $("#name").val()
    let phone = $("#phone").val()
    let memo = $("#memo").val()
    $.ajax({
        url : "create",
        method : "post",
        data : {"name" : name, "phone":phone , "memo" : memo},
        success : function(re){
            alert("Restful create 통신")

        }
    })
}

function data_read() {
    alert("R")
    $.ajax({
            url : "read",
            method : "get",
            success : function(re){
                alert("Restful read 통신")
            }
        })
}

function data_update() {
    alert("U")
    $.ajax({
            url : "update",
            method : "put",
            success : function(re){
                alert("Restful update 통신")
            }
        })
}

function data_delete(){
    alert("D")
    $.ajax({
            url : "delete",
            method : "delete",
            success : function(re){
                alert("Restful delete 통신")
            }
        })
}