public class Subject{
	private double grade;
	private double units;
	private String courseName;
	public Subject(String courseName, double grade,double units){
		this.courseName = courseName;
		this.grade = grade;
		this.units = units;
	}
	public double getGrade(){
		return this.grade;
	}
	public double getUnits(){
		return this.units;
	}
	public String getCourseName(){
		return this.courseName;
	}
	public void setGrade(double grade){
		this.grade = grade;
	}
	public void setUnits(double units){
		this.units = units;
	}
	public void setCourseName(String courseName){
		this.courseName = courseName;
	}
	public double getWeight(){
		return this.grade * this. units;
	}
}