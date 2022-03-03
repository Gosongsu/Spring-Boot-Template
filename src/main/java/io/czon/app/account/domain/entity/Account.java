package io.czon.app.account.domain.entity;
import io.czon.app.domain.entity.AuditingEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder @Getter @ToString
public class Account extends AuditingEntity {

    @Id
    @GeneratedValue
    @Column(name = "account_id")
    private Long id;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String nickname;

    private String password;

    private String emailToken;

    private LocalDateTime joinedAt;

    private boolean isVaild;

    public void generateToken() {
        this.emailToken = UUID.randomUUID().toString();
    }

    public void verified() {
        this.isVaild = true;
        joinedAt = LocalDateTime.now();
    }


}