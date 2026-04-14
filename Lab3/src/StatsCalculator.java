public class StatsCalculator {

    public static void main(String[] args) {
        // 1. Initialize the 2D array with the sample data (you may copy and paste it from sample_data.txt)
        double[][] scores= {
            {1, 85.50, 90.0, 78.5, 92.0},
            {2, 76.0, 88.5, 90.0, 85.0},
            {3, 95.0, 92.0, 94.5, 98.0},
            {4, 60.0, 70.5, 65.0, 72.0},
            {5, 82.0, 84.0, 80.0, 88.0},
        }; 

        // 2. Call methods
        System.out.println("--- GradeBook Statistics ---\n");
        calculateStudentAverages(scores);
        System.out.println();
        calculateAssignmentAverages(scores);
        System.out.println();
        findHighestScore(scores);
    }

    // TODO: Implement this method
    public static void calculateStudentAverages(double[][] data) {
        System.out.println("Student Averages:");
        // Your logic here (Row-major traversal)
        for (int i = 0; i < data.length; i++) {
            double sum = 0;
            for (int j = 1; j < data[i].length; j++) {
                sum += data[i][j];
            }
            double average = sum / (data[i].length - 1);
            System.out.println("Student " + (int)data[i][0] + ": " + average);
        }
    }
    // TODO: Implement this method
    public static void calculateAssignmentAverages(double[][] data) {
        System.out.println("Assignment Averages:");
        // Your logic here (Column-major traversal)
        for (int j = 1; j < data[0].length; j++) {
            double sum = 0;
            for (int i = 0; i < data.length; i++) {
                sum += data[i][j];
            }
            double average = sum / data.length;
            System.out.println("Assignment " + j + ": " + average);
        }
    }

    // TODO: Implement this method
    public static void findHighestScore(double[][] data) {
         // Your logic here
        double highestScore = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 1; j < data[i].length; j++) {
                if (data[i][j] > highestScore) {
                    highestScore = data[i][j];
                }
            }
        }
        for (int i = 0; i < data.length; i++) {
            for (int j = 1; j < data[i].length; j++) {
                if (data[i][j] == highestScore) {
                    System.out.println("Highest Score by Student " + (int)data[i][0] + " for Assignment " + j);
                }
            }
        }
        System.out.println("Highest Score in Class: " + highestScore);
    }
  
    
}