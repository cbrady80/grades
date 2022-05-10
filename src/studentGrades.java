import java.util.*;

public class studentGrades {
    /**
     * GET SCORES
     * Purpose: prompts for users scores and adds them to a list, and returns an average.
     * @return the average value
     */
    public static int getScores() {
        // Create a Scanner for user input
        Scanner input = new Scanner(System.in);

        // Create an arrayList and declare variables
        ArrayList<Integer> scoresList = new ArrayList<>();
        int sum = 0;
        int average = 0;

        // Prompt for input until they type "Q" to quit.
        System.out.print("Please enter a percentage number score (type Q to quit): ");

        // Save scores in the arrayList
        while (input.hasNextInt()) {
            int number = input.nextInt();
            scoresList.add(number);
            System.out.print("Please enter a number score (type Q to quit): ");
        }

        // Compute scores average
        if(!scoresList.isEmpty()) {
            for (Integer score : scoresList) {
                sum += score;
            }
            average =  sum / scoresList.size();
        }
        return average;
    }


    /**
     * COMPUTE LETTER GRADE
     * Purpose: takes the average from the input of the number grades and
     * converts them to a letter grade.
     * @return a letter grade
     */
    public static String computeLetterGrade(int average) {
        // Figures out which letter the average number applies to
        String letterGrade = switch (average / 10) {
            case 10, 9 -> "A";
            case 8 -> "B";
            case 7 -> "C";
            case 6 -> "D";
            default -> "F";
        };

        return letterGrade;
    }


    /**
     * COMPUTE GRADE SIGN
     * Purpose: takes the average from the input of the number grades and
     * determines if it should have a + or - added to the letter, and
     * adds it if applicable.
     * @return grade sign
     */
    public static String computeGradeSign(int average) {
        String gradeSign = "";

        // for 97 and up
        if(average >= 97) {
            gradeSign = "\n";
        }

        // grades to add a plus = 7,8,9 except on A's and F's
        if(average <= 89 && average >= 60) {
            if(average % 10 == 7 ||
               average % 10 == 8 ||
               average % 10 == 9) {
                gradeSign = "+\n";
            }
        }

        // grades to add a minus = 0,1,2 except on F's, 100 and up, or no sign.
        if(average <= 99 && average >= 60){
            if(average % 10 == 0 ||
               average % 10 == 1 ||
               average % 10 == 2) {
                gradeSign = "-\n";
            }
            else if(average % 10 == 3 ||
                    average % 10 == 4 ||
                    average % 10 == 5 ||
                    average % 10 == 6) {
                gradeSign = "\n";
            }
        }

        return gradeSign;
    }



    /**
     * MAIN
     * Driver program to prompt user for input and displays the letter grade.
     */
    public static void main(String[] args) {
        // Explanation upon start of program.
        System.out.println("This program will accept a list of student percentage scores, \n" +
                "compute the average, and tell you your letter grade.\n");

        // Call to getScores input method.
        int average = getScores();

        // Display the letter grade.
        System.out.println("Your grade is: " + computeLetterGrade(average) + computeGradeSign(average));

    }

}
