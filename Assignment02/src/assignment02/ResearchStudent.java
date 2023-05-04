
package assignment02;

/**
 * 
 * @author Freeman
 */

public class ResearchStudent extends Student
{
    /**Marks of proposal Component for research student
    */
    private double proposalComponent;
    /**Marks of oral Presentation for research student
    */
    private double oralPresentation;
    /**Marks of final Thesis for research student
    */
    private double finalThesis;
    /**Marks of average to calculate average mark for research student
    */
    private double average;
    /**Marks of overall mark for research student
    */
    private double overallMark;
    
     /**Default Constructor for ResearchStudent class
     *<p>
     * A default constructor to intialise the call method from another class
     * With the default values
     *</p>
     */
    
    public ResearchStudent()
    {
        super();
        proposalComponent = oralPresentation = finalThesis = average = 0.0;
    }
    
     /** Parameterised constructor 
     * <p>
     * This method is an inheritance of Student class and a few other variable for the Research students
     * Using super to inheritance the variables fro student class
     * </p>
     * post-condition Student class and CourseworkStudent object created.
     * @param proposalComponent  The proposal component marks 
     * @param oralPresentation  The oral presentation marks
     * @param finalThesis  The final thesis marks
     */
    
    public ResearchStudent(String title, String firstName, String lastName, long id,
            int day, int month, int year, double pc, double op, double ft)
    {
        super(title, firstName, lastName, id, day, month, year);
        this.proposalComponent = pc;
        this.oralPresentation = op;
        this.finalThesis = ft;
    }
    
     /**This method is used to check the grades of the research students
     * Using super to inheritance the variables from student class
     * <p>
     * @param TotalGrade store the grades and check them.
     * @return Grades in HD,D,C,P,N
     * </p>
     */
    
    public String ResearchGrading()
    {
        double TotalGrade = ResearchCalculateOverallMark();
        return super.Grading(TotalGrade);           
    }
    
     /** This method is used to calculate the average marks of the research students                     
     * <p>
     * Precondition: average is initialised at the Constructor  </br>
     * </p>    
     * @return average marks of the students of the research students
     */
    
    
    public void AverageCalculate()
    {
        average += proposalComponent * 0.30;
        average += oralPresentation * 0.10;
        average += finalThesis * 0.60;   
    }
    
     /** This method is used get the course average marks as an object                       
     * <p>
     * Precondition: average is initialised at the Constructor  </br>
     * </p>   
     * @return average marks of the research students
     */
     
    public double getResearchAverage()
    {
        return average;
    }
    
     /** This method is used to calculate the marks of the research students                      
     * <p>
     * Precondition: overallMark is initialised at the Constructor  </br>
     * </p>    
     * @return overall marks of the research students
     */
    
    public double ResearchCalculateOverallMark()
    {
        overallMark = proposalComponent*0.30 + oralPresentation*0.10 + finalThesis*0.60;
        
        return overallMark;
    }
    
     /** This method is used get the research marks as an object                       
     * <p>
     * Precondition: overallMark is initialised at the Constructor  </br>
     * </p>   
     * @return overall marks
     */
 
    public double getResearchOverallMark()
    {
        ResearchCalculateOverallMark();
        return overallMark;
    }
    
     /**Get the information of the research student using this method and use it as a printing
     * <p>
     * combining the title, firstName, lastName, id, Date Of Birth, DOB, proposalComponent, oralPresentation, finalThesis, overallmark, ResearchGrading
     * Using super to inheritance the variables from student class
     * </p>
     * @return title, firstName, lastName, id, Date Of Birth, DOB, proposalComponent, oralPresentation, finalThesis, overallmark, ResearchGrading
     */
    
    public String toString()
    {
        String researchResult = super.toString();
        researchResult += "\nProposal Component: " + proposalComponent
                + "\nOral Presentation: " + oralPresentation
                + "\nFinal Thesis: " + finalThesis
                + "\nResearch Students Averages: " + overallMark 
                + "\nResearch Students Grades: " + ResearchGrading();
                
        return researchResult;
    }
    
     /**Get the information of the research student using this method and store them into a CSV file 
     * <p>
     * combining the title, firstName, lastName, id, Date Of Birth, DOB, proposalComponent, oralPresentation, finalThesis, overallmark, ResearchGrading
     * Using super to inheritance the variables from student class
     * </p>
     * @return title, firstName, lastName, id, Date Of Birth, DOB, proposalComponent, oralPresentation, finalThesis, overallmark, ResearchGrading
     */
    
    public String toStringCSVFormat()
    {
        String researchResultCSV = super.toStringCSVFormat();
        researchResultCSV += "\nProposal Component: " + proposalComponent
                + "\nOral Presentation: " + oralPresentation
                + "\nFinal Thesis: " + finalThesis
                + "\nResearch Students Averages: " + overallMark 
                + "\nResearch Students Grades: " + ResearchGrading();
                
        return researchResultCSV;
    }  
}
