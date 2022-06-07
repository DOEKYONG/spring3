package springtest3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 스프링부트 초기 셋팅 : 1. 내장 톰캣 셋팅 2. MVC 셋팅 3.RESTful 셋팅
public class AppStart {

    public static void main(String[] args) {

        SpringApplication.run(AppStart.class);

    }
}

/*
    프로젝트폴더
        src
            main
                1. java [백엔드파일]
                        2. 최상위패키지[웹페이지 명]
                            3. controller 패키지
                            3. service 패키지
                            3. domain 패키지
                            3. 스프링실행클래스[*]
                    1. resources[ 프론트엔드 / 설정파일 ]
                        2. static
                            3. js
                            3. css
                            3. img
                        2. templates [ HTML 파일 ]
                        2. application.properties [ 앱 설정파일 ]
 */

/*
    MVC2 : 작업파일 패키지 업무분담[JPA]
        * 안전성 보장 [ VIEW -> CONTROLLER // CONTROLLER -> SERVICE : PARAM,DTO,VO]
            DTO : 데이터 이동 객체 (/이동/읽기/수정 모드) [ CONTROLLER -> SERVICE ]
            VO : 데이터 이동객체 (읽기모드)
            entity : DB 테이블과 매핑된 객체 ( SERVICE 에서만 사용 권장 )


    VIEW ------AJAX------> CONTROLLER --------------> SERVICE ------JPA--------------> DB
    화면                  제어(VIEW<-->SERVICE)         로직          entity ----매핑---> table
                                                                            entity 조작 : JPARepository
    - 통신방식 : AJAX
        -URL : create       @[METHOD]GetMapping(URL)
        -METHOD : get
                            SERVICE 메소드 호출         기능구현 로직

    JDBC : JAVA DATABASE CONNECTION  종류
    1. DAO [ JAVAFX,JSP ]
    2. JPA [ SPRING ]

    * JPA : 매핑[연결]
    // 목적 : SQL 최소화 [ 자바개발자가 SQL 반복작성 회피 ]
    // 매핑 : ENTITIY(JAVA 클래스) ---------- DB(테이블)

    @RequestParam <-----------> request.getParameter
        1. 변수요청 어노테이션
        2. 자동 형변환


 */
