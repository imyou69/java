import java.util.Scanner;

class Employee {
    String empID;
    String empName;
    long empPhone;
    float empSalary;

    public void accept() {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter Staff ID:");
        empID = obj.nextLine();
        System.out.println("Enter Name:");
        empName = obj.nextLine();
        System.out.println("Enter Phone number:");
        empPhone = obj.nextLong();
        System.out.println("Enter Salary:");
        empSalary = obj.nextFloat();
    }

    public void display() {
        System.out.println("Staff ID: " + empID);
        System.out.println("Name: " + empName);
        System.out.println("Phone: " + empPhone);
        System.out.println("Salary: " + empSalary);
    }
}

class Teaching extends Employee {
    String domain;
    int n;

    public void accept() {
        super.accept();
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter Domain:");
        domain = obj.nextLine();
        System.out.println("Enter number of Publications:");
        n = obj.nextInt();
    }

    public void display() {
        super.display();
        System.out.println("Domain: " + domain);
        System.out.println("Publications: " + n);
    }
}

class Technical extends Employee {
    String skill;

    public void accept() {
        super.accept();
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter Technical Skills:");
        skill = obj.nextLine();
    }

    public void display() {
        super.display();
        System.out.println("Technical Skills: " + skill);
    }
}

class Contract extends Employee {
    int period;

    public void accept() {
        super.accept();
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter Period:");
        period = obj.nextInt();
    }

    public void display() {
        super.display();
        System.out.println("Contract Period: " + period);
    }
}

class EmployeeFour {
    public static void main(String[] args) {
        Teaching teach = new Teaching();
        System.out.println("Enter the details of Teaching Staff:");
        teach.accept();
        Technical tech = new Technical();
        System.out.println("Enter the details of Technical Staff:");
        tech.accept();
        Contract con = new Contract();
        System.out.println("Enter the details of Contract Staff:");
        con.accept();
        System.out.println("The details of Teaching Staff:");
        teach.display();
        System.out.println("The details of Technical Staff:");
        tech.display();
        System.out.println("The details of Contract Staff:");
        con.display();
    }
}
