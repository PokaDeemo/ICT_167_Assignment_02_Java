
package assignment02;

/**
 * 
 * @author Freeman
 */

public class CourseWorkStudent extends Student
{
    /**Marks of Assignment 1 for coursework student
     * and
     * Marks of Assignment 2 for coursework student	
     */
    private double assignment1, assignment2;
    /**Marks of Practical Work for coursework student
     */
    private double practicalWork;
     /**Marks of final Exam for coursework student
     */
    private double finalExam;
     /**Marks of average to calculate average mark for coursework student
     */
    private double average;
     /**Marks of overall mark for coursework student
     */
    private double overallMark;
    
     /**Default Constructor for CourseWorkStudent class
     *<p>
     *A default constructor to intialise the call method from another class
     * With the default values
     *</p>
     */
    
    public CourseWorkStudent()
    {
        super();
        assignment1 = assignment2 = practicalWork = finalExam = average = 0.0;
    }
    
    /** Parameterised constructor 
     * <p>
     * This method is an inheritance of Student class and a few other variable for the Coursework students
     * Using super to inheritance the variables fro student class
     * </p>
     * post-condition Student class and CourseworkStudent object created.
     * @param assignment1  The assignment 1 marks 
     * @param assignment2  The assignment 2 marks
     * @param practicalWork  The Practical Work marks
     * @param finalExam The Exam marks
     */
    
    public CourseWorkStudent(String title, String firstName, String lastName, long id, 
            int day, int month, int year, double as1, double as2, double pw, double fe)
    {
        super(title, firstName, lastName, id, day ,month, year);
        this.assignment1 = as1;
        this.assignment2 = as2;
        this.practicalWork = pw;
        this.finalExam = fe;
    }
    
     /**This method is used to check the grades of the coursework students
     * Using super to inheritance the variables fro student class
     * <p>
     * @param TotalGrade store the grades and check them.
     * @return Grades in HD,D,C,P,N
     * </p>
     */
    
    public String CourseWorkGrading()
    {
        double TotalGrade = CourseWorkcalculateOverallMark();
        return super.Grading(TotalGrade);              
    }
    
    /** This method is used to calculate the average marks of the coursework students                     
     * <p>
     * Precondition: average is initialised at the Constructor  </br>
     * </p>    
     * @return average marks of the students
     */
    
    public void AverageCalculate()
    {
        average += (assignment1*0.25) + (assignment2*0.25); 
        average += practicalWork*0.20;
        average += finalExam*0.30;            
    }
    
     /** This method is used get the course average marks as an object                       
     * <p>
     * Precondition: average is initialised at the Constructor  </br>
     * </p>   
     * @return average marks of the coursework students
     */
    
    public double getCourseWorkAverage()
    {
        return average;
    }
    
     /** This method is used to calculate the marks of the coursework students                      
     * <p>
     * Precondition: overallMark is initialised at the Constructor  </br>
     * </p>    
     * @return overall marks of the coursework students
     */
        
    public double CourseWorkcalculateOverallMark()
    {
        overallMark = assignment1*0.25 + assignment2*0.25+practicalWork*0.20+finalExam*0.30;
        
        return overallMark;
    }
    
    /** This method is used get the course marks as an object                       
     * <p>
     * Precondition: overallMark is initialised at the Constructor  </br>
     * </p>   
     * @return overall marks
     */
    
    public double getCourseWorkOverallMark()
    {
        CourseWorkcalculateOverallMark();
        return overallMark;        
    }   
    
     /**Get the information of the coursework student using this method and use it as a printing
     * <p>
     * combining the title, firstName, lastName, id, Date Of Birth, DOB, assignment1 , assignment2, practicalwork, finalexam, overallMark, CourseWorkGrading
     * Using super to inheritance the variables from student class
     * </p>
     * @return title, firstName, lastName, id , DOB, assignment1 , assignment2,  practicalwork, finalexam, overallMark, CourseWorkGrading
     */
    
    public String toString()
    {
        String courseworkResult = super.toString();
        courseworkResult += "\nAssignment1: " + assignment1
                + "\nAssignment2: " + assignment2
                + "\nPractical Work: " + practicalWork
                + "\nFinal Exam: " + finalExam
                + "\nCourseWork Students Averages: " + overallMark
                + "\nCourseWork Students Grades: " + CourseWorkGrading();     
        return courseworkResult;
    }
    
     /**Get the information of the coursework student using this method and store them into a CSV file 
     * <p>
     * combining the title, firstName, lastName, id, Date Of Birth, DOB, assignment1 , assignment2, practicalwork, finalexam, overallMark, CourseWorkGrading
     * Using super to inheritance the variables from student class
     * </p>
     * @return title, firstName, lastName, id , DOB, assignment1 , assignment2,  practicalwork, finalexam, overallMark, CourseWorkGrading
     */
    
    public String toStringCSVFormat()
    {
        String courseResultCSV = super.toStringCSVFormat();
        courseResultCSV += "\nAssignment1: " + assignment1
                + "\nAssignment2: " + assignment2
                + "\nPractical Work: " + practicalWork
                + "\nFinal Exam: " + finalExam
                + "\nCourseWork Students Averages: " + overallMark
                + "\nCourseWork Students Grades: " + CourseWorkGrading();     
        return courseResultCSV;
    }
}
