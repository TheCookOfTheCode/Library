package app;

import utils.DataReader;
import data.Book;
import data.Library;

public class LibraryControl {
	public static final int EXIT=0;
	public static final int ADD_BOOK=1;
	public static final int PRINT_BOOKS=2;

	private DataReader dataReader;  // zmienna do komunikacji z u�ytkownikiem
	
	private Library library; // "biblioteka" przechowuj�ca dane
	
	public LibraryControl() {
		dataReader = new DataReader();
		library = new Library();
	}
	
	public void controlLoop() {
		int option;
		printOptions();
		while ((option = dataReader.getInt()) != EXIT) {
			switch (option) {
			case ADD_BOOK:
				addBook();
				break;
			case PRINT_BOOKS:
				printBooks();
				break;
			default:
				System.out.println("Nie ma takiej opcji, wprowad� ponownie: ");
			}
			printOptions();
		}
		//zamykamy strumie� wej�cia
		dataReader.close();
	}
	
	private void printOptions() {
        System.out.println("Wybierz opcj�: ");
        System.out.println(EXIT +" - wyj�cie z programu");
        System.out.println(ADD_BOOK +" - dodanie nowej ksi��ki");
        System.out.println(PRINT_BOOKS +" - wy�wietl dost�pne ksi��ki");
	}
	
	private void addBook() {
		Book book = dataReader.readAndCreateBook();
		library.addBook(book);
	}
	
	private void printBooks() {
		library.printBooks();
	}
	
}
