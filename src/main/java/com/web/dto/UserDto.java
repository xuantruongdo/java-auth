package com.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.web.entity.Authority;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class UserDto {

    private Long id;

    private String username;

    private String email;

    private String fullname;

    private String password;

    private String phone;

    private Boolean actived;

    private Date createdDate;

    private String avatar;

    private int gender;

    private String address;

    private Authority authorities;
}

