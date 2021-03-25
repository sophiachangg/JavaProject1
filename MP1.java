//Sophia Chang, CIS 340, 3:00
import java.util.Scanner;
import java.util.ArrayList;

public class MP1 {
	static String[] names;
	static double[][] scores;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfScores = 0;
		int numberOfStudents = 3;
		names = new String[3];
		
		//ask user for number of scores for each student 
		System.out.print("How many scores per student? ");
		numberOfScores = Integer.parseInt(scanner.nextLine());
		System.out.println();
		
		populateArrays(numberOfStudents, numberOfScores);
		showMenu();
		
	} //end main method

//	private static void printArray(int size1, int size2){
//		for(int i = 0; i < size1; i++){
//			for(int j = 0; j < size2; j++){
//				System.out.print(scores[i][j] + " ");
//			} //end nested for loop
//			System.out.println();
//		} //end outer for loop
//	} //end printArray method

	private static void populateArrays(int numberOfStudents, int numberOfScores) {	
		Scanner scanner = new Scanner(System.in);
		scores = new double [numberOfStudents][numberOfScores];
		
		//enter student names into names array
		for (int i = 0; i < numberOfStudents; i++) {
			System.out.printf("Enter name for student %d: ", i + 1);
			names[i] = scanner.nextLine();
			
			System.out.println();
			System.out.printf("Entering scores for %s", names[i].toUpperCase());
			System.out.println();
			
			//enter quiz scores for each student into scores array
			for (int j = 0; j < numberOfScores; j++) {
				System.out.printf("Quiz %d: ", j + 1);
				scores[i][j] = Double.parseDouble(scanner.nextLine());
				
			} //end for loop that populates quiz scores
			System.out.println();
		} //end for loop that populates scores for each student
	} //end populateArrays method 
	
	private static void showMenu() {
		Scanner scanner = new Scanner(System.in);
		String input = "";
		String enter = "";
		
		//print menu to show user and have them select what they want to calculate
		do {
			System.out.println("\n\n\n\n\n");
			System.out.println("\t\t\tMenu");
			System.out.println("1. Class Average");
			System.out.println("2. Student Average");
			System.out.println("3. Quiz Average\n");
			System.out.print("Enter choice number, or x to exit: ");
			input = scanner.nextLine();
			//calls the method that the user wants to calculate 
			switch(input) {
			case "1":
				calculateClassAvg();
				break;
			case "2":
				calculateStudentAvg();
				break;
			case "3": 
				calculateQuizAvg();
				break;
			default:
				break;
			} //end switch statement
			System.out.print("\n\n\nPress ENTER to continue...");
			enter = scanner.nextLine();
		} while (!input.equalsIgnoreCase("x"));
		
		return;
	} //end showMenu method
	
	private static void calculateClassAvg() {
		double tempScores = 0.0;
		double numberOfStudents = 0.0;
		double numberOfScores = 0.0;
		double classAverage = 0.0;
		
		//loop through scores array to calculate class average for all quiz scores
		for(int i = 0; i < scores.length; i++) {
			numberOfStudents = scores.length;
			numberOfScores = scores[i].length;
			for(int j = 0; j < scores[i].length; j++ ) {
				tempScores += scores[i][j];
			} //end nested for loop
		} //end outer for loop
		
		//calculate average for the entire class and print
		classAverage = tempScores/numberOfStudents/numberOfScores;
		System.out.printf("Class average for all quizzes is %.2f", classAverage);
		
		return;
	} //end calculateClassAvg method
	
	private static void calculateStudentAvg() {
		Scanner scanner = new Scanner(System.in);
		String tempName = "";
		boolean nameFound = false;
		double tempScores = 0.0;
		double studentAverage = 0.0;
		int studentIndex = 0;
		
		System.out.println("\nCalculating average by student.\n");
		System.out.print("Enter student name: ");
		tempName = scanner.nextLine();
		
		//loop through names array to see if name provided is in the array
		for (int i = 0; i < names.length; i++ ) {
			if (tempName.equalsIgnoreCase(names[i])) {
				nameFound = true;
				studentIndex = i;
				System.out.printf("%s's scores are: ", names[i]);
			} //end nested if statement 
		} //end for loop
		
		//account for name given not being in the array
		if(nameFound == false) {
			System.out.println("Student not found.");
			return;
		} //end if statement
		
		//loop through scores array to add a student's scores 
		for(int j = 0; j < scores[studentIndex].length; j++ ) {
			tempScores += scores[studentIndex][j];
			System.out.printf("%.2f ", scores[studentIndex][j]);
		} //end for loop
		
		//calculate average for each student and print
		studentAverage = tempScores/scores[studentIndex].length;
		System.out.printf("\n%s's average is %.2f", tempName, studentAverage);
			
		return;
	} //end calculateStudentAvg method
	
	private static void calculateQuizAvg() {
		Scanner scanner = new Scanner(System.in);
		double quizNumber = 0.0;
		double tempScores = 0.0;
		double quizAverage = 0.0;
		
		System.out.println("\nCalculating average by Quiz Number");
		System.out.print("Enter Quiz number: ");
		quizNumber = Double.parseDouble(scanner.nextLine());
		
		//loop through scores array to get each student's scores of that quiz
		for (int i = 0; i < scores.length; i++) {
			tempScores += scores[i][(int)quizNumber - 1];
		} //end for loop
		
		//calculate the average of that quiz and print
		quizAverage = tempScores/scores.length;
		System.out.printf("\nQuiz %.2f average is %.2f", quizNumber, quizAverage);
			
		return;
	} //end calculateQuizAvg method
	
} //end MP1 class
