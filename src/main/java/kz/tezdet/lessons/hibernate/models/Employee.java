package kz.tezdet.lessons.hibernate.models;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="employee", catalog = "hibernate_db2")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId ;

    @Column(name = "firstname")
    private String firstName ;
    @Column(name = "lastname")
    private String lastName ;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="employee_meeting",
    joinColumns = @JoinColumn(name="employee_id"),
    inverseJoinColumns = @JoinColumn(name="meeting_id"))
    private Set<Meeting> meetings = new HashSet<Meeting>() ;

    public Employee(){

    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Meeting> getMeetings() {
        return meetings;
    }

    public void setMeetings(Set<Meeting> meetings) {
        this.meetings = meetings;
    }
}
