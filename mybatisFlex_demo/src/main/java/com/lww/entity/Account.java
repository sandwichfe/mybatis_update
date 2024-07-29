package com.lww.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Table("tb_account")
public class Account {

    @Id(keyType = KeyType.Auto)
    private Long id;

    @Column("user_name")
    private String userName;

    private Integer age;

    private Date birthday;

    @Column(onInsertValue = "now()")
    private LocalDateTime createTime;

    @Column(onUpdateValue = "now()")
    private LocalDateTime updateTime;

}
