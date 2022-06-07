function data_create(){
    alert("저장");

    let name = $("#name").val();
    let phone = $("#phone").val();
    let memo = $("#memo").val();

    $.ajax({        // 비동기
        url: "create",  // 1.통신 경로
        method: "post" , // 2.통신 방식
        data : { "name" : name , "phone" : phone , "memo" : memo } , // 3.통신 데이터
        success: function( re ){    // 4.통신 응답
            alert("RESTFUL create 통신 "+ re);
        }
    });

}
//
//type: 보낼 타입을 지정한다. 설정안하면 get으로 가므로 사실 위의 예제에서는 생략해도 가능. 보통 가독성때문에 적는 경우가 많음
//
//method: type과 동등하다. 사실 type이 옛날부터 존재하고 method가 뒤에생겼다. 구버전은 type만 사용가능

function data_read(){
    alert("호출");
       $.ajax({
            url: "read",
            method: "get" ,
            success: function( re ){
                alert("RESTFUL read 통신 " );
                console.table(  re )


            }
        });
}

function data_update(){
    alert("수정");
       $.ajax({
            url: "update",
            method: "put" ,
            success: function( re ){
                alert("RESTFUL update 통신 ");
            }
        });
}
function data_delete(){
    alert("삭제");
       $.ajax({
            url: "delete",
            method: "delete" ,
            success: function( re ){
                alert("RESTFUL delete 통신 ");
            }
        });
}