package springtest3.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springtest3.domain.dto.MemberDto;
import springtest3.service.Indexservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class IndexController {

    // RESTFUL 정의
    // 1. 자원( URL ) 2.행위(HTTP Method ) 3. 표현
    // 2. 행위( HTTP Method )
    //                                  CRUD            차이 [ 멱등성 = 기록 O / X  ]
    // 1. @PostMapping           C                X
    // 2. @GetMapping            R                O
    // 3. @PutMapping             U               O
    // 4. @DeleteMapping        D               O

    //  * 여러번 호출했을때 POST는 호출할때마다 데이터 새롭게 생성
    //   *  AJAX  -------------> SPRING CONTROLLER
    //       AJAVA    method : POST      ------------->         @PostMapping
    //       AJAVA    method : GET      ------------->          @GetMapping
    //       AJAVA    method : PUT      ------------->          @PutMapping
    //      AJAVA    method : DELETE      ------------->     @DeleteMapping

    @GetMapping("/")
    public String index(){
        return "main";
    }

    @Autowired  // 자동 빈생성   // new 사용하지 않아도 메모리 할당
    Indexservice indexservice;

    @PostMapping("/create")
    @ResponseBody
    public Boolean create(  @RequestParam("name") String name ,
                            @RequestParam("phone")  String phone ,
                            @RequestParam("memo")  String memo ){
//        // 1. DTO 풀생성자 사용
//        MemberDto memberDto = new MemberDto( 0 , name    , phone , memo);
//        // 2. DTO 빈생성자 사용
//        MemberDto memberDto2 = new MemberDto();
//            memberDto2.setNo( 0 );
//            memberDto2.setName(name);
//            memberDto2.setPhone(phone);
//            memberDto2.setMemo(memo);
        // 3. builder 사용시           객체명 = Dto명.builder().필드명1(값1).필드명2(값2).필드명3(값3).build();
        MemberDto memberDto3 = MemberDto.builder()
                .phone(phone)
                .name(name)
                .memo(memo)
                .build();
        // 생성자 vs 빌더 차이점 [ 빌더 : 안정성 보장 ]
        // 1. 생성자 인수 순서를 무조건 지켜야한다.!!!!!
        // 2. 생성자 인수 개수를 무조건 맞춘다.!!!!!
        System.out.println(  "dto 확인 : " +  memberDto3.toString() );
        boolean result =  indexservice.create( memberDto3 );

        return result;
    }
    @GetMapping("/read")
    public void read(HttpServletResponse response ){

        List<MemberDto> dtos =  indexservice.read();

        JSONArray jsonArray = new JSONArray();
        // json 형변환
        for ( MemberDto dto :  dtos ){
            JSONObject object = new JSONObject();
            object.put( "no" , dto.getNo() );
            object.put( "name" , dto.getName() );
            object.put( "phone" , dto.getPhone() );
            object.put( "memo" , dto.getMemo() );
            jsonArray.put( object );
        }
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            response.getWriter().print(jsonArray);
        }catch( Exception e ){ System.out.println(e);}

    }
    @PutMapping("/update")
    @ResponseBody
    public String update(){

        indexservice.update();

        return "수정 성공";
    }
    @DeleteMapping("/delete")
    @ResponseBody
    public String delete(){

        indexservice.delete();

        return "삭제 성공";
    }

}