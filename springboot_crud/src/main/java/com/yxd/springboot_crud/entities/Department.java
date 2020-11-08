package com.yxd.springboot_crud.entities;

public class Department {

	private Integer did;
	private String departmentName;

	public Department() {
	}
	
	public Department(int i, String string) {
		this.did = i;
		this.departmentName = string;
	}

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "Department [id=" + did + ", departmentName=" + departmentName + "]";
	}
	
}
