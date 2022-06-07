package springtest3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springtest3.domain.dto.MemberDto;
import springtest3.service.Indexservice;

@Controller
public class IndexController {

    // RESTFUL 정의
        // 1. 자원(url)  3. 표현
    // 2. 행위( HTTP Method )
//                                CRUD        차이 [멱등성 = 기록 O/X ]
        // 1. @PostMapping         C           X
        // 2. @GetMapping          R           O
        // 3. @PutMapping          U           O
        // 4. @DeleteMapping       D           O

        // * 여러번 호출했을때 POST는 호출할때마다 데이터 새롭게 생성
        //  * AJAX ----------> SPRING CONTROLLER
        //     AJAX     method : POST --------> @PostMapping
        //     AJAX     method : GET --------> @GetMapping
        //     AJAX     method : PUT --------> @PutMapping
        //     AJAX     method : DELETE --------> @DeleteMapping


    @GetMapping("/")
    public String index() {
        return "main";
    }



    @Autowired
    Indexservice indexservice;

    @PostMapping("/create")
    @ResponseBody
    public boolean create( @RequestParam ("name") String name,
                          @RequestParam ("phone") String phone,
                          @RequestParam ("memo") String memo ){


        // 1. DTO  풀생성자생성
        MemberDto memberDto = new MemberDto(0,name,phone,memo);
       // 2. DTO 빈생성자 사용
        MemberDto memberDto2 = new MemberDto();
            memberDto2.setNo(0);
            memberDto2.setName(name);
            memberDto2.setPhone(phone);
            memberDto2.setMemo(memo);

        // 3. builder 사용시
        MemberDto memberDto3 = MemberDto.builder()
                .phone(phone)
                .name(name)
                .memo(memo)
                .build();
        // 생성자 vs 빌더 차이점 [ 빌더 : 안정성 보장 ]
            // 1. 생성자 인수 순서를 무조건 지켜야된다
            // 2. 생성자 인수 개수를 무조건 맞춘다.

        System.out.println("DTO확인:"+memberDto3.toString());

        indexservice.create(memberDto3);

        boolean result = indexservice.create(memberDto3);

        return result;
    }

    @GetMapping("/read")
    @ResponseBody
    public String read(){

        indexservice.read();
        return "불러오기 성공";
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
