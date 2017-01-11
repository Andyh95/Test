import java.util.ArrayList;
import java.io.*;
public class Main {  
	static ArrayList<Person> newPeople = new ArrayList<>();
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		ArrayList<Person> people = new ArrayList<>();
		people.add(new Person("John Smith","Fisherman",34));
		people.add(new Person("Jane Doe","Librarian",26));
		people.add(new Person("Alan Smith","Software Engineer",23));
		people.add(new Person("Mary Jane","Lawyer",35));
		people.add(new Person("Joe Bloggs","IT Support",21));
		
		FileWriter fStream = new FileWriter("out.txt");
		BufferedWriter out = new BufferedWriter(fStream);
		for(Person person : people)
		{
			out.write(person.name + ", " + person.occupation + ", " + person.age + "\n");
		}
		out.close();			
		
		readFiles();	
		for(Person person : newPeople)
		{
			System.out.println(person.name + ", " + person.occupation + ", " + person.age);
		}
	}

	static void readFiles() throws IOException
	{
		FileReader rStream = new FileReader("out.txt");
		BufferedReader in = new BufferedReader(rStream);
		String line;
		while((line = in.readLine()) != null){
			
		String name = "";
		String job = "";
		String age = "";
	
		int splittingPoint1 = 0;
		int splittingPoint2 = 0;
		
		for(int i = 0; i < line.length() ;i++)
		{			
			if(line.charAt(i) == ',')
			{
				if(splittingPoint1 == 0)
					splittingPoint1 = i;
				else
					splittingPoint2 = i;	
			}
		}
		
		for(int j = 0; j < splittingPoint1 ;j++)
			name += line.charAt(j);
				
		for(int j = splittingPoint1+2; j < splittingPoint2 ;j++)
			job += line.charAt(j);
		
		for(int j = splittingPoint2+2; j < line.length() ;j++)
			age += line.charAt(j);
				

		int actualAge = Integer.parseInt(age);
		newPeople.add(new Person(name, job, actualAge));
		
	}
		in.close();
	}
}
