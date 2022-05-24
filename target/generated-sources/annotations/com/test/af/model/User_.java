package com.test.af.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, String> firstName;
	public static volatile SingularAttribute<User, String> lastName;
	public static volatile SingularAttribute<User, String> birthPlace;
	public static volatile SingularAttribute<User, Long> unid;
	public static volatile SingularAttribute<User, String> address;
	public static volatile SingularAttribute<User, String> gender;
	public static volatile SingularAttribute<User, LocalDate> birthDate;
	public static volatile SingularAttribute<User, String> email;

	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String BIRTH_PLACE = "birthPlace";
	public static final String UNID = "unid";
	public static final String ADDRESS = "address";
	public static final String GENDER = "gender";
	public static final String BIRTH_DATE = "birthDate";
	public static final String EMAIL = "email";

}

