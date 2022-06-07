package springtest3.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity // 일반 클래스 -> jpa entity 으로 사용
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString
@Table(name="membertest")
public class MemberEntity {
    @Id // PK 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto key
    public Integer no;

    @Column
    public String name;

    @Column
    public String phone;

    @Column
    public String memo;


}
