
package assignment02;

/**
 * 
 * @author Freeman
 */

public class Student
{
    /** Title of the student
     */
    private String title; 
    /** First name of the student
     */
    private String firstName;
    /** Last name of the student
     */
    private String lastName;
    /** Grade of the student and printing-out the grade format
     */
    private String grade;
    /** ID of the student
     */
    private long id;
    /** Day, month, year of the student date of birth
     */
    private int day, month, year;
    
    /**Default Constructor for Student class
     *<p>
     *A default constructor to intialise the call method from another class
     * With the default values
     *</p>
     */
  
    public Student()
    {
        title = firstName = lastName = "";
        id = day = month = year = 0;
    }
    
    /** Parameterised constructor 
	 * <p>
	 * This method is used to represent the Title,firstName ,lastName, i, Day, Month, Year 
	 * </p>
	 * post condition  Student object created of the all the private variables
	 * @param title  The status of the student
	 * @param firstName  The first name of the student
	 * @param lastName  The last name of the student
	 * @param id  The ID of the student
	 * @param day The date of birth of the student
         * @param Month The month of date of birth of the student
         * @param Year The year of birth of the student
	*/
    
    public Student(String title, String firstName, String lastName, long id, int day, int month, int year)
    {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    /** Gets Title value
     * @return a string value 
     */
    
    public String getTitle()
    {
        return title;
    }
    
    /** Gets FirstName value
     * @return a string value
     */
    
    public String getFirstName()
    {
        return firstName;
    }
    
    /** Gets LastName value
     * @return a string value 
     */
    
    public String getLastName()
    {
        return lastName;
    }
    
    /** Gets the full name of the student using this method
     *  combining FirstName an LastName
     * @return a string value
     */
    
    public String getName()
    {
        return firstName+" "+lastName;
    }
    
    /** Gets Id value
     * @return a long value 
     */
    
    public long getId()
    {
        return id;
    }
    
    /** Gets Day value
     * @return a long value 
     */
    
    public int getDay()
    {
        return day;
    }
    
    /** Gets Month value
     * @return a long value 
     */
    
    public int getMonth()
    {
        return month;
    }
    
    /** Gets Year value
     * @return a long value 
     */
    
    public int getYear()
    {
        return year;
    }
    
    /** Gets the date of birth of the student using this method
     *  combining the day, month and year
     * @return a string value
     */
    
    public String getDOB()
    {
        return day + "/" + month + "/" + year;
    }
    
     /**This method is used set the Title of the Student object       
     * Getter and Setter and mostly came in pair
     * <p>
     * Precondition: Title is initialised at the Constructor 
     * postcondition: A string to hold the Title.
     * </p><br>
     * @param title A String containing Student object title 
     */
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
     /**This method is used set the FirstName of the Student object       
     * Getter and Setter and mostly came in pair
     * <p>
     * Precondition: FirstName is initialised at the Constructor 
     * postcondition: A string to hold the FirstName.
     * </p><br>
     * @param FirstName A String containing Student object FirstName 
     */
    
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
      /**This method is used set the LastName of the Student object       
     * Getter and Setter and mostly came in pair
     * <p>
     * Precondition: LastName is initialised at the Constructor 
     * postcondition: A string to hold the LastName.
     * </p><br>
     * @param FirstName A String containing Student object LastName 
     */
    
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
     /**This method is used set the id of the Student object       
     * Getter and Setter and mostly came in pair
     * <p>
     * Precondition: id is initialised at the Constructor 
     * postcondition: A long to hold the student ID.
     * </p><br>
     * @param id A long containing Student object id 
     */
    
    public void setId(long id)
    {
        this.id = id;
    }
    
      /**This method is used set the date of birth of the Student object       
     * Getter and Setter and mostly came in pair
     * <p>
     * Precondition: DOB is initialised at the Constructor 
     * postcondition: A String to hold the student DOB.
     * </p><br>
     * @param DOB A String containing Student object Date of birth 
     */
    
    public void setDOB(int day, int month, int year)
    {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    /** Gets grade value
     * @return a integer value 
     */
    
    public String getGrade() 
    {
        return grade;
    }
    
    /** Sets the grade value.
     * @param Grade containing no value
     */
    
    public void setGrade(String grade)
    {
        this.grade = grade;
    }
    
    /** Get the grades of the student using this method
     * <p>
     * @param TotalGrade store the grades and check them.
     * @return Grades in HD,D,C,P,N
     * </p>
     */
    
    public String Grading(double TotalGrade) 
    {
         if(TotalGrade >= 80.0)
            grade = "HD";
        else if(TotalGrade >= 70.0 && TotalGrade < 80.0)
            grade = "D";
        else if(TotalGrade >= 60.0 && TotalGrade  < 70.0)
            grade = "C";
        else if(TotalGrade >= 50.0 && TotalGrade < 60.0)
            grade = "P";
        else
            grade = "N"; 
         
        return grade;
    }
    
    /**Get the information of the student using this method and use it as a printing
     * <p>
     * combining the title, firstName, lastName, id and Date Of Birth
     * </p>
     * @return Title, firstName, lastName, id , DOB
     */
    
    public String toString()
    {
        return "\nName: " + title + " " + firstName+ " " + lastName + "\nID: " + id + "\nDOB: " + getDOB();
    }
    
    /**Get the information of the student using this method and store them into a CSV file 
     * <p>
     * combining the title, firstName, lastName, id and Date Of Birth
     * </p>
     * @return Title, firstName, lastName, id , DOB
     */
    
    public String toStringCSVFormat()
    {
        return id+" "+title+" "+firstName+" "+lastName+" "+day+" "+month+" "+year+" ";
    }
    
    /**This method is compare and check one student to another
     * <p>
     * @param equals store the Full name and DOB of the student 
     * and check them to see weather does any student have the same Full name and DOB.
     * </p>
     */
    
    public boolean equals(Object other)
    {
        if(other == this)
            return true;
        if(!(other instanceof Student))
            return false;
        
        Student stud = (Student) other;
        String insName = title + firstName + lastName;
        String othName = stud.title + stud.firstName + stud.lastName;
        
        if(insName.equalsIgnoreCase(othName) && getDOB().equalsIgnoreCase(stud.getDOB()))
            return true;
        else
            return false; 
    }   
}
