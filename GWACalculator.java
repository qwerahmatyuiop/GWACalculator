import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

public class GWACalculator{
	public static double totalWeight = 0.0;
	public static double totalUnits = 0.0 ;
	public static int subjects = 0;
	public static double currentGWA = 0.0;
	public static LinkedList<Subject> listOfSubjects = new LinkedList<Subject>();
	public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String [] args) throws IOException{
		String input = "";
		printMenu();

		while((!(input = reader.readLine()).equals("5"))){
				if(input.equals("1")){
					getNewSubject();
				}else if(input.equals("2")){
					System.out.println("Pick Subject:");
					printSubjects();
					EditSubject(Integer.parseInt(reader.readLine()));
				}else if(input.equals("3")){
					printSubjects();
				}else if(input.equals("4")){
					writeToFile();
				}
				printMenu();
		}
	}
	private static void getNewSubject() throws IOException{
		String name ="";
		double grade = 0.0;
		double units = 0.0;
		System.out.print("Input Subject Name:");
		name = reader.readLine();
		System.out.print("Input Units:");
		units = Double.parseDouble(reader.readLine());
		System.out.print("Input Grade:");
		grade = Double.parseDouble(reader.readLine());
		Subject s = new Subject(name,grade,units);
		totalUnits += s.getUnits();
		totalWeight += s.getWeight();
		subjects++;
		listOfSubjects.add(s);
	}
	private static void printMenu(){

		System.out.println("\t----------GWA CALCULATOR----------");
		if(totalWeight != 0.0 || totalUnits != 0.0){
			System.out.println("\t|\tTotal Subjects: "+subjects+"\t|");
			System.out.println("\t|\tTotal Units: "+totalUnits+"\t|");
			System.out.println("\t|\tTotal GWA: "+computeGWA()+"\t\t|");
			System.out.println("\t----------------------------------");
		}
		System.out.println("[1] Add Subject");
		System.out.println("[2] Edit Subject");
		System.out.println("[3] Print Subjects");
		System.out.println("[4] Write to File");
		System.out.println("[5] Exit");
		System.out.print("Input:");
	}
	private static double computeGWA(){
		return totalWeight/totalUnits;
	}
	private static void printSubjects()throws IOException{
		int i = 1;
		System.out.println("\f");
		System.out.println("SUBJECTS:");
		System.out.println("\tCOURSE NAME\tUNITS \tGRADE");
		for(Subject s: listOfSubjects){
			System.out.println("\t["+(i++)+"] "+s.getCourseName()
							+"\t"+s.getUnits()+"\t"+s.getGrade()+ " ");
			}
	}
	private static void writeToFile() throws IOException{
		int i = 1;
		File file = new File("Grades.text");
		PrintWriter writer = new PrintWriter("Grades.text", "utf-8");
		writer.println("SUBJECTS:");
		writer.println("\tCOURSE NAME\tUNITS \tGRADE");
		for(Subject s: listOfSubjects){
			writer.println("\t["+(i++)+"] "+s.getCourseName()
							+"\t"+s.getUnits()+"\t\t"+s.getGrade()+ " ");
		}
		writer.println("\n\t|\tTotal Subjects: "+subjects+"\t|");
		writer.println("\t|\tTotal Units: "+totalUnits+"\t\t|");
		writer.println("\t|\tTotal GWA: "+computeGWA()+"\t\t|");
		writer.close();

	}
	private static void EditSubject(int n)throws IOException{
		if(n > listOfSubjects.size()){ System.out.println("Invalid Input!"); return;}
		Subject newSub = listOfSubjects.get(n-1);
		totalUnits -= newSub.getUnits();
		totalWeight -= newSub.getWeight();
		System.out.print("Input Subject Name:");
		newSub.setCourseName(reader.readLine());
		System.out.print("Input Units:");
		newSub.setUnits(Double.parseDouble(reader.readLine()));
		System.out.print("Input Grade:");
		newSub.setGrade(Double.parseDouble(reader.readLine()));
		totalUnits += newSub.getUnits();
		totalWeight += newSub.getWeight();
	}
}