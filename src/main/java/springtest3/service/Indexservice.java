package springtest3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springtest3.domain.dto.MemberDto;
import springtest3.domain.entity.MemberEntity;
import springtest3.domain.entity.MemberRepository;


import java.util.ArrayList;
import java.util.List;

@Service
public class Indexservice { // 자바 로직 실행되는 클래스

    @Autowired // 자동 빈 생성
    MemberRepository memberRepository;
    // 1. 생성
    public boolean create(MemberDto memberDto){

        System.out.println("save service");
        // 1. Dto -> entitiy 변환
        MemberEntity memberEntitiy = memberDto.changeEntity();
        // 2. entitiy save
        memberRepository.save( memberEntitiy ); //  저장 후에 기본키 빼오기
        // 3. 반환
        return  true;

    }
    // 2.  호출
    public List<MemberDto> read(){
        System.out.println("read service ");

        List<MemberEntity> entitiys = memberRepository.findAll(); // 아무조건 없는 모든 엔티티 호출

        // entitiy 리스트 -> dto 리스트 변환
        List<MemberDto> dtos = new ArrayList<>(); // dto 담는 리스트 선언

        for( MemberEntity entitiy : entitiys  ){ // 반복문

            dtos.add(    MemberDto.builder()
                    .no( entitiy.getNo() )
                    .name( entitiy.getName() )
                    .phone( entitiy.getPhone() )
                    .memo( entitiy.getMemo())
                    .build()    );
        }
        return dtos;
    }
    // 3. 수정
    public void update(){
        System.out.println("update service");

    }
    // 4. 삭제
    public void delete(){
        System.out.println("delete service");

    }
}