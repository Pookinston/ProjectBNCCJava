import java.util.*;

public class Main {
	Scanner sc = new Scanner(System.in);
	ArrayList<Employee> Karyawan = new ArrayList<Employee>();
	int managerCount = 0;
	int supervisorCount = 0;
	int adminCount = 0;
	int total=0;

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}
	
	public Main() {
		int choice = 0;
		while(choice != 5) {
			menu();
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				String name = "";
				String gender;
				String pos;
				String kode;
				
				// input nama
				do {
					System.out.println("Input nama karyawan [>= 3]: ");
					sc.nextLine();
				    name = sc.nextLine();
				}while(name.length() < 3);
				
				//input gender
				do {
					System.out.println("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
					gender = sc.nextLine();
				}while(gender.equals("Laki-laki") == false && gender.equals("Perempuan") == false);
				
				//ID
				kode = generateID();
				
				//input jabatan
				do {
					System.out.println("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
					pos = sc.nextLine();
				}while(pos.equals("Manager") == false && pos.equals("Supervisor") == false && pos.equals("Admin") == false);

				if(pos.equals("Manager")) {
					Karyawan.add(new Manager(name, gender, kode));
					managerCount++;
				}
				else if(pos.equals("Supervisor")) {
					Karyawan.add(new Supervisor(name, gender, kode));
					supervisorCount++;
				}
				else if(pos.equals("Admin")) {
					Karyawan.add(new Admin(name, gender, kode));
					adminCount++;
				}
				
				System.out.println("Berhasil menambahkan karyawan dengan id " + kode);
				total++;
				
				//bonus
				if(pos.equals("Manager")) {
					int count = 0;
					
					if((managerCount-1) %3 == 0 && managerCount>1) {
						System.out.print("Bonus sebesar 10% telah diberikan kepada karyawan dengan id:");
						for(Employee e : Karyawan) {
							if(e.getPosition().equals("Manager")){
								e.setSalary((int) (e.getSalary()+e.getSalary()*0.1));
								System.out.print(" "+e.getID());
								count++;
							}
							if(count == managerCount-1) {
								System.out.println();
								break;
							}
						}
					}
				}
				else if(pos.equals("Supervisor")) {
					int count = 0;
					
					if((managerCount-1) %3 == 0 && managerCount>1) {
						System.out.print("Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id:");
						for(Employee e : Karyawan) {
							if(e.getPosition().equals("Supervisor")){
								e.setSalary((int) (e.getSalary()+e.getSalary()*0.75));
								System.out.print(" "+e.getID());
								count++;
							}
							if(count == managerCount-1) {
								System.out.println();
								break;
							}
						}
					}
				}
				else if(pos.equals("Admin")) {
					int count = 0;
					
					if((managerCount-1) %3 == 0 && managerCount>1) {
						System.out.print("Bonus sebesar 5% telah diberikan kepada karyawan dengan id:");
						for(Employee e : Karyawan) {
							if(e.getPosition().equals("Admin")){
								e.setSalary((int) (e.getSalary()+e.getSalary()*0.05));
								System.out.print(" "+e.getID());
								count++;
							}
							if(count == managerCount-1) {
								System.out.println();
								break;
							}
						}
					}
				}
				System.out.println();
				break;
				
			case 2:
				view();
				System.out.println();
				break;
				
			case 3:
				Collections.sort(Karyawan, new Comparator<Employee>() {
				    @Override
				    public int compare(Employee e1, Employee e2) {
				        return e1.getName().compareTo(e2.getName());
				    }
				});
				view();
				int pick= 0;
				System.out.println("Nomor yang ingin diganti: ");
				pick = sc.nextInt();
				//kode karyawan, nama karyawan, jenis kelamin, jabatan, gaji karyawan yang baru
				
				if(Karyawan.get(pick-1).getPosition().compareTo("Manager") == 1) {
					managerCount--;
				}
				else if(Karyawan.get(pick-1).getPosition().compareTo("Supervisor") == 1) {
					supervisorCount--;
				}
				else if(Karyawan.get(pick-1).getPosition().compareTo("Admin") == 1) {
					adminCount--;
				}
				
				String name1 = "";
				String gender1;
				String pos1;
				String kode1;
				
				// input nama
				do {
					System.out.println("Input nama karyawan [>= 3]: ");
					sc.nextLine();
				    name1 = sc.nextLine();
				}while(name1.length() < 3);
				
				//input gender
				do {
					System.out.println("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
					gender1 = sc.nextLine();
				}while(gender1.equals("Laki-laki") == false && gender1.equals("Perempuan") == false);
				
				//ID
				kode1 = generateID();
				
				//input jabatan
				do {
					System.out.println("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
					pos1 = sc.nextLine();
				}while(pos1.equals("Manager") == false && pos1.equals("Supervisor") == false && pos1.equals("Admin") == false);

				if(pos1.equals("Manager")) {
					Karyawan.set(pick-1, new Manager(name1, gender1, kode1));
					managerCount++;
				}
				else if(pos1.equals("Supervisor")) {
					Karyawan.set(pick-1, new Supervisor(name1, gender1, kode1));
					supervisorCount++;
				}
				else if(pos1.equals("Admin")) {
					Karyawan.set(pick-1, new Admin(name1, gender1, kode1));
					adminCount++;
				}
				
				System.out.println("Berhasil update karyawan di nomor " + pick);
				total++;
				
				
				break;
			case 4:
				Collections.sort(Karyawan, new Comparator<Employee>() {
				    @Override
				    public int compare(Employee e1, Employee e2) {
				        return e1.getName().compareTo(e2.getName());
				    }
				});
				view();
				int pick1= 0;
				pick1 = sc.nextInt();
				System.out.println("Nomor yang ingin dihapus: ");
				
				if(Karyawan.get(pick1-1).getPosition().compareTo("Manager") == 1) {
					managerCount--;
				}
				else if(Karyawan.get(pick1-1).getPosition().compareTo("Supervisor") == 1) {
					supervisorCount--;
				}
				else if(Karyawan.get(pick1-1).getPosition().compareTo("Admin") == 1) {
					adminCount--;
				}
				
				Karyawan.remove(pick1-1);
				System.out.println("Berhasil di hapus");
				System.out.println();
				break;
			}
		}
	}
	
	public void menu() {
		System.out.println("1. Insert data karyawan");
		System.out.println("2. View data karyawan");
		System.out.println("3. Update data karyawan");
		System.out.println("4. Delete data karyawan");
		System.out.println("5. Exit");
		System.out.print(">> ");
	}
	
	//generate random id
	public String generateID(){
		Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            sb.append((char) (r.nextInt(26) + 'A')); // random alphabet
        }
        sb.append("-");
        for (int i = 0; i < 4; i++) {
            sb.append(r.nextInt(10)); // random number
        }
        String randomString = sb.toString();
        return randomString;
	}
	
	public void view() {
		System.out.println(String.format("%-5s %-15s %-20s %-15s %-15s %-15s", "No.", "Kode Karyawan", "Nama Karyawan", "Jenis Kelamin", "Jabatan", "Gaji Karyawan"));

		for (int i = 0; i < Karyawan.size(); i++) {
		    Employee e = Karyawan.get(i);
		    System.out.println(String.format("%-5d %-15s %-20s %-15s %-15s %-15d", i+1, e.getID(), e.getName(), e.getGender(), e.getPosition(), e.getSalary()));
		}
	}

}

abstract class Employee {
    private String name;
    private String gender;
    protected String position;
    protected int salary;
    private String id;
    
    public Employee(String name, String gender, String id) {
        this.name = name;
        this.gender = gender;
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getPosition() {
        return position;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public String getID() {
        return id;
    }
    public void setID(String id) {
        this.id = id;
    }
}

class Manager extends Employee {

    public Manager(String name, String gender, String id) {
        super(name, gender, id);
        this.position = "Manager";
        this.salary = 8000000;
    }
}


class Supervisor extends Employee {

    public Supervisor(String name, String gender, String id) {
        super(name, gender, id);
        this.position = "Supervisor";
        this.salary = 6000000;
    }
}


class Admin extends Employee {

    public Admin(String name, String gender, String id) {
        super(name, gender, id);
        this.position = "Admin";
        this.salary = 4000000;
    }
}