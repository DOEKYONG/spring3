package springtest3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springtest3.domain.dto.MemberDto;
import springtest3.domain.entity.MemberRepository;
import springtest3.domain.entity.MemberEntity;

@Service
public class Indexservice {

    @Autowired
    MemberRepository memberRepository;
    // 1. 생성
    public boolean  create(MemberDto memberDto){

        System.out.println("save service");

        MemberEntity memberEntity = memberDto.changeEntity();

        int no = memberRepository.save(memberEntity).getNo();

        System.out.println("저장된 엔티티 번호" +no);

        if(no > 0) {
            return true;
        }else {
            return false;
        }


    }
    // 2. 호출
    public void  read(){

        System.out.println("read service");
    }
    // 3. 수정
    public void  update(){

        System.out.println("update service");
    }
    // 4. 삭제
    public void  delete(){

        System.out.println("delete service");
    }

}
