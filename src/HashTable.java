
import java.util.LinkedList;

public class HashTable
{
	private LinkedList<Student> arr[];
	public static final int LEN = 8;
	/**
	 * Constructor method initializes array of type LinkedList with length LEN
	 * Each element of the array is initialized to a LinkedList of type Student
	 */
	public HashTable(){
		arr = new LinkedList[LEN];
		for (int i = 0; i < LEN; i++){
			arr[i] = new LinkedList<Student>();
		}
	}

	/**
	 * Method to hash a student's ID to a slot in the array
	 * Precondition: s is a string composed only of alphanumeric characters.
	 * Postcondition: The sum of the ASCII values of s modulo LEN is returned
	 * @param s
	 * @return
	 */
	public int hashValue(String s){
		// Your implementation of the hash function goes here.
		// For help with getting ASCII values of characters, see asciiIntDemo.java
		int sum = 0;
		for (int i = 0; i < s.length(); i++){
			sum += s.charAt(i);
		}
		return sum % LEN;
	}

	/**
	 * Precondition:name is a string composed of alphanumeric characters.
	 * Postcondition: If the hash table contains a student by this name, then return true.
	 * Otherwise, return false
	 * @param name
	 * @return
	 */
	public boolean search(String name){
		int index = hashValue(name);
		LinkedList<Student> list = arr[index];
		for (Student s : list){
			if (s.getName().equals(name)){
				return true;
			}
		}return false;
	}

	/**
	 * Precondition: name is a string composed of alphanumeric characters and age is a
	 * positive integer.
	 * Postcondition: If the hash table does not contain a Student of this name, then a
	 * Student with attributes name and age is added to the appropriate linked list in the
	 * hash table. If a Student of this name is already in the hash table, then this Student has
	 * their age updated to the inputted age. Additionally, a message is printed indicating
	 * that a student is being inserted and their name and age. You may choose to use a
	 * more specific message when a student’s age is being modified
	 * @param name
	 * @param age
	 */
	public void insert(String name, int age){
		// Remember that if a student of this name already exists in the table,
		// you should modify that student's age. Otherwise, add a Student with
		// appropriate name and age to the end of the appropriate linked list
		int index = hashValue(name);
		LinkedList<Student> list = arr[index];
		for (Student s : list){
			if (s.getName().equals(name)){
				int prevAge = s.getAge();
				s.setAge(age);
				System.out.println("Changing age of " + name + " from "+ prevAge + " to " + age);
				return;
			}
		}
		list.addFirst(new Student(name, age));
		System.out.println("Student " + name + " is being inserted with age " + age);
	}

	/**
	 * Precondition: name is a string composed of alphanumeric characters.
	 * Postcondition: If the hash table contains a Student with this name, this Student
	 * is removed from the hash table. Otherwise, a message is printed indicating that no
	 * Student of this name was found in the hash table.
	 * @param name
	 */
	public void delete(String name){
		// Remember that if the hash table has no students of this name,
		// then you should print a message indicating this.
		int index = hashValue(name);
		LinkedList<Student> list = arr[index];
		for (Student s : list){
			if (s.getName().equals(name)){
				list.remove(s);
				System.out.println("Student " + name + " is being deleted");
				return;
			}
		}
		System.out.println("Student " + name + " is not in the hash table");
	}

	/**
	 * Precondition: name is a string composed of alphanumeric characters.
	 * Postcondition: If the hash table contains a Student with this name, this Student
	 * is removed from the hash table. Otherwise, a message is printed indicating that no
	 * Student of this name was found in the hash table.
	 * @param name
	 */
	public int getAge(String name){
		// Remember that if the hash table has no students of this name,
		// then you should print a message indicating this and return -1.
		int index = hashValue(name);
		LinkedList<Student> list = arr[index];
		for (Student s : list){
			if (s.getName().equals(name)){
				return s.getAge();
			}
		}
		System.out.println("Student " + name + " is not in the hash table");
		return -1;
	}

	/**
	 * Precondition: name is a string composed of alphanumeric characters.
	 * Postcondition: If the hash table contains a Student with this name, then this
	 * student’s age is incremented by 1 and a message is printed to indicate this. Otherwise,
	 * a message is printed indicating that no student of this name was found in the hash
	 * table
	 * @param name
	 */
	public void increment(String name){
		// Remember that if the hash table has no students of this name,
		// then a message should be printed indicating this
		int index = hashValue(name);
		LinkedList<Student> list = arr[index];
		for (Student s : list){
			if (s.getName().equals(name)){
				s.setAge(s.getAge() + 1);
				System.out.println("Student " + name + " is being incremented by 1");
				return;
			}
		}
		System.out.println("Student " + name + " is not in the hash table");
	}

	/**
	 * Precondition: arr is an array of LinkedList of Student.
	 * Postcondition: A string is returned that contains the names of all students in the hashtable
	 * @return a string representation of the hash table
	 */
	public String toString(){
		// Hint: It’s intended that you use the built-in toString()
		// for LinkedList, which will implicitly call the toString()
		// for Student, which has already been implemented.
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++){
			sb.append(i + ": " + arr[i].toString() + "\n");
		}
		return sb.toString();
	}
}