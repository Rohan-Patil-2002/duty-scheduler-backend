package com.rp.duty_droid.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "users")
public class User {

	//Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "badge_id")
    private String badgeId;

    @Column(name = "name")
    private String name;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "mobile_no", unique = true, nullable = false)
    private String mobileNo;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password")
    private String password;
    
    @Transient
    private String newPassword;

    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "status")
    private String status;


    //Default Constructor
    public User() {
    }

    //Parameterized Constructor
    public User(Long userId, String badgeId, String name, String departmentName,
                String mobileNo, String email, String password,
                Long roleId, String status) {
        this.userId = userId;
        this.badgeId = badgeId;
        this.name = name;
        this.departmentName = departmentName;
        this.mobileNo = mobileNo;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
        this.status = status;
    }

    //Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getBadgeId() {
        return badgeId;
    }

    public void setBadgeId(String badgeId) {
        this.badgeId = badgeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNewPassword() {
		
		return newPassword;
	}

}
