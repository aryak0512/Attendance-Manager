package com.beans;

public class Subject {
	int id;
	String name;
	String attended;
	String total;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAttended() {
		return attended;
	}
	public void setAttended(String attended) {
		this.attended = attended;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", attended=" + attended + ", total=" + total + "]";
	}
	
	
	

}
