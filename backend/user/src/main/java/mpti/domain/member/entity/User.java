package mpti.domain.member.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;


import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

//    @Id
//    @GeneratedValue(generator = "uuid2")
//    @GenericGenerator(name = "uuid2", strategy = "uuid2")
//    @Column(name = "user_id", columnDefinition = "BINARY(16)")
//    private UUID id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Ptlog ptlog;

    @Column(unique = true)
    private String email;

    private Role role;

    // 하면 이거 json 으로 파싱할 때 비밀번호 정보는 주지 않는다고 한다.
    @Column(nullable = false)
    private String password;
    private int age;
    private String gender;
    private String phone;
    private String address;
    @CreatedDate
    @Column(name = "create_at")
    private LocalDateTime createAt;

    @LastModifiedDate
    @Column(name = "update_at")
    private LocalDateTime updateAt;

    private String provider;

    public User() {
    }


    public void setEmail(String email) {

        if(email != null) this.email = email;
    }

    public void setName(String name) {
        if(name != null) this.name = name;
    }
    public void setPassword(String password) {
        if(password != null) this.password = password;
    }

    public void setAge(int age) {
        if(age != 0) this.age = age;
    }

    public void setGender(String gender) {
        if(gender != null)this.gender = gender;
    }

    public void setPhone(String phone) {
        if(phone != null) this.phone = phone;
    }

    public void setAddress(String address) {
        if(address != null) this.address = address;
    }

    public void setCreateAt(LocalDateTime createAt) {
        if(createAt != null) this.createAt = createAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        if(updateAt != null) this.updateAt = updateAt;
    }

    public void setProvider(String provider) {if(provider != null)this.provider = provider;}

    public void setPtlog(Ptlog ptlog) {
        if(ptlog != null){
            this.ptlog = ptlog;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ptlog=" + ptlog +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", provider='" + provider + '\'' +
                '}';
    }

    //    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", ptlog=" + ptlog +
//                ", email='" + email + '\'' +
//                ", name='" + name + '\'' +
//                ", password='" + password + '\'' +
//                ", age=" + age +
//                ", gender='" + gender + '\'' +
//                ", phone='" + phone + '\'' +
//                ", address='" + address + '\'' +
//                ", createAt=" + createAt +
//                ", updateAt=" + updateAt +
//                '}';
//    }

//    @Builder
//    public User(UUID id, String name, Ptlog ptlog, String email, Role role, String password, int age, String gender, String phone, String address, LocalDateTime createAt, LocalDateTime updateAt) {
//        this.id = id;
//        this.name = name;
//        this.ptlog = ptlog;
//        this.email = email;
//        this.role = role;
//        this.password = password;
//        this.age = age;
//        this.gender = gender;
//        this.phone = phone;
//        this.address = address;
//        this.createAt = createAt;
//        this.updateAt = updateAt;
//    }

    @Builder
    public User(long id, String name, Ptlog ptlog, String email, Role role, String password, int age, String gender, String phone, String address, LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id;
        this.name = name;
        this.ptlog = ptlog;
        this.email = email;
        this.role = role;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }


}
