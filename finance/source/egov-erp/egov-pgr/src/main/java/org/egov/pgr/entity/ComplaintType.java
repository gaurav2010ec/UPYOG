package org.egov.pgr.entity;

import org.egov.lib.rjbac.dept.DepartmentImpl;
import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;

@Entity
@Table(name = "pgr_complainttype", uniqueConstraints = @UniqueConstraint(columnNames = { "name" }))
public class ComplaintType extends AbstractPersistable<Long> {

	@NotBlank(message = "{error-not-empty}")
	@Length(min = 1, max = 150, message = "{error-min-max-length-exceed}")
	@SafeHtml(message = "{error-input-unsafe}")
	@NaturalId
	private String name;
	
	@Length(max = 200, message = "{error-max-length-exceed}")
	@SafeHtml(message = "{error-input-unsafe}")
	private String description;
	
	@ManyToOne
	@Valid
	private DepartmentImpl department;
	
	@Digits(fraction=2,message="{error-not-valid}",integer=9)
	private BigDecimal amount;
	
	private boolean isLocationRequired;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public DepartmentImpl getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentImpl department) {
		this.department = department;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public boolean getIsLocationRequired() {
		return isLocationRequired;
	}
	public void setIsLocationRequired(boolean isLocationRequired) {
		this.isLocationRequired = isLocationRequired;
	}
}
