package springtest3.domain.dto;

import lombok.*;
import springtest3.domain.entity.MemberEntity;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder // 객체 생성시 안전성 보장 Builder 메소드 제공

public class MemberDto {
    public Integer no;
    public String name;
    public String phone;
    public String memo;
    // 설계 관련 api : 롬복 : 생성자,get,set,빌더,toString()

// 1. dto -> entity 변환메소드
    public MemberEntity changeEntity() {
        MemberEntity memberEntity = MemberEntity.builder()
                .name(this.name)
                .phone(this.phone)
                .memo(this.memo)
                .build();
        return memberEntity;

    }




}
