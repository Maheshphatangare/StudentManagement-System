package com.mongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Data
@Document(collection="stud")
public class Stud {
	@Id
private int id;
private String name;
private String city;
private String college;
}
