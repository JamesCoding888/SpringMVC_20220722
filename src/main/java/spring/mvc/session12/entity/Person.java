package spring.mvc.session12.entity;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
public class Person {
	@NotNull(message = "{person.name.notEmpty}")
	@Size(min=2, max=50, message="{person.name.size}")
	private String name; 			  // name
	
	@NotNull(message="{person.age.notNull}")
	@Range(min=18, max=99, message = "{person.age.range}")
	private Integer age; 			  // age
	
	@NotNull(message="{person.member.notNull}")
	private Boolean member;  // whether is member or not
	
	@NotNull(message="{person.birth.notNull}")
	@Past(message = "{person.birth.past}")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birth; 				  // birthday
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Boolean getMember() {
		return member;
	}
	public void setMember(Boolean member) {
		this.member = member;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", member=" + member + ", birth=" + birth + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
