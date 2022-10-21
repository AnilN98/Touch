package com.touch.model;

import java.io.FileInputStream;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="profileregisterers")
public class ProfileRegisterer 
{
	public ProfileRegisterer() {}
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	String id;
	
	@Column(name="profileID")
	private String proflieId;
	
	@Column(name="bio")
	private String bio;
	
	@Column(name="dob")
	private String dob;
	
	@Column(name="profileStatus")
	private String status;
	
	@Column(name="notification")
	private String notification;
	
	@Column(name="chat")
	private String chat;
	
	@Column(name="profilePic", columnDefinition="BLOB")
	private byte[] fileimage;
	
	@Column(name="interests")
	private String interests;
	
	@Column(name="email")
	private String email;
	

	public ProfileRegisterer(String touchId, String bio, String dob, String status,
			byte[] profilePic, String interests, String email) {
		super();
		this.proflieId = touchId;
		this.bio = bio;
		this.dob = dob;
		this.status = status;
		this.notification = notification;
		this.chat = chat;
		this.fileimage = profilePic;
		this.interests = interests;
		this.email = email;
	}

	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public String getTouchId() {
		return proflieId;
	}

	public void setTouchId(String touchId) {
		this.proflieId = touchId;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}

	public String getChat() {
		return chat;
	}

	public void setChat(String chat) {
		this.chat = chat;
	}

	
	
	

	

	public byte[] getFileimage() {
		return fileimage;
	}

	public void setFileimage(byte[] fileimage) {
		this.fileimage = fileimage;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProflieId() {
		return proflieId;
	}

	public void setProflieId(String proflieId) {
		this.proflieId = proflieId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "ProfileRegisterer [touchId=" + proflieId + ", bio=" + bio + ", dob=" + dob + ", status=" + status
				+ ", notification=" + notification + ", chat=" + chat + ", profilePic=" + fileimage + ", interests="
				+ interests + "]";
	}
	
	
	
}
