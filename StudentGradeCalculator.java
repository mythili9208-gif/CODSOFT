import java.util.Scanner;

public class StudentGradeCalculator {
    //Determine grade
    public static String getGrade(double mark) {
        if (mark >= 90)
            return "A";
        else if (mark >= 80)
            return "B";
        else if (mark >= 70)
            return "C";
        else if (mark >= 60)
            return "D";
        else
            return "F";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println(" STUDENT GRADE CALCULATOR ");
        System.out.println("=================================");

        System.out.print("Enter Student Name : ");
        String studentName = sc.nextLine();

        System.out.print("Enter Student ID : ");
        String studentId = sc.nextLine();

        System.out.print("Enter Number of Subjects : ");
        int n = sc.nextInt();

        String[] subjects = new String[n];
        double[] marks = new double[n];

        double total = 0;

        for (int i = 0; i < n; i++) {

            sc.nextLine();

            System.out.print("\nEnter Subject Name : ");
            subjects[i] = sc.nextLine();

            System.out.print("Enter Mark : ");
            marks[i] = sc.nextDouble();

            total += marks[i];
        }

        double average = total / n;
        String overallGrade = getGrade(average);

        int choice;

        do {

            System.out.println("\n========== MENU ==========");
            System.out.println("1. Total Mark");
            System.out.println("2. Average Mark");
            System.out.println("3. Overall Grade");
            System.out.println("4. Specific Subject Grade");
            System.out.println("5. Full Report");
            System.out.println("6. Exit");
            System.out.print("Enter Choice : ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nTotal Mark = " + total);
                    break;

                case 2:
                    System.out.println("\nAverage Mark = " + average);
                    break;

                case 3:
                    System.out.println("\nOverall Grade = " + overallGrade);
                    break;

                case 4:

                    System.out.println("\nSubject Grades");

                    for (int i = 0; i < n; i++) {
                        System.out.println(
                                subjects[i] + " = " +
                                getGrade(marks[i]));
                    }

                    break;

                case 5:

                    System.out.print(
                        "\nDo you want to print full report? (yes/no): ");

                    sc.nextLine();
                    String reportChoice = sc.nextLine();

                    if (reportChoice.equalsIgnoreCase("yes")) {

                        System.out.println(
                                "\n========================================");
                        System.out.println(
                                "      STUDENT GRADE REPORT");
                        System.out.println(
                                "========================================");

                        System.out.println(
                                "Student Name : " + studentName);

                        System.out.println(
                                "Student ID   : " + studentId);

                        System.out.println(
                                "\n----------------------------------------");

                        System.out.printf(
                                "%-15s %-10s %-10s\n",
                                "Subject",
                                "Mark",
                                "Grade");

                        System.out.println(
                                "----------------------------------------");

                        for (int i = 0; i < n; i++) {

                            System.out.printf(
                                    "%-15s %-10.2f %-10s\n",
                                    subjects[i],
                                    marks[i],
                                    getGrade(marks[i]));
                        }

                        System.out.println(
                                "----------------------------------------");

                        System.out.println(
                                "Total Mark    : " + total);

                        System.out.println(
                                "Average Mark  : " + average);

                        System.out.println(
                                "Overall Grade : " + overallGrade);

                        System.out.println(
                                "========================================");
                    }

                    break;

                case 6:
                    System.out.println(
                            "\nThank You For Using Student Grade Calculator");
                    break;

                default:
                    System.out.println(
                            "\nInvalid Choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}