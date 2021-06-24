package linkedList;

import java.util.LinkedList;
import java.util.*;

public class Demo {
	public static void main(String[] args) {
		// create linkedlist
		// LinkedList advantages: can add the element in alphabetical order.
		// Java has implemented the LinkedList as a double linkedList, has reference
		// link to next item and previous item.

		LinkedList<String> placesToVisit = new LinkedList<String>();
		addInOrder(placesToVisit, "Sydney");
		addInOrder(placesToVisit, "Melbourne");
		addInOrder(placesToVisit, "Brisbane");
		addInOrder(placesToVisit, "Perth");
		addInOrder(placesToVisit, "Canberra");
		addInOrder(placesToVisit, "Adelaide");
		addInOrder(placesToVisit, "Darwin");
		printList(placesToVisit);

		addInOrder(placesToVisit, "Alice Springs");
		addInOrder(placesToVisit, "Darwin");
		printList(placesToVisit);

		visit(placesToVisit);

	}

	private static void printList(LinkedList<String> linkedList) {
		Iterator<String> i = linkedList.iterator();

		while (i.hasNext()) {
			System.out.println("Now visiting " + i.next());
		}

		System.out.println("==============================");
	}

	private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
		ListIterator<String> stringListIterator = linkedList.listIterator();
		while (stringListIterator.hasNext()) {
			int comparsion = stringListIterator.next().compareTo(newCity);
			// 0: current index city == newCity, >0: current index city > newCity <->
			// newCity should before current,
			// <0: current index city < newCity <-> move on to the next index in the linked
			// list
			if (comparsion == 0) {
				System.out.println(newCity + " is already included as a destination");
				return false;
			} else if (comparsion > 0) {
				stringListIterator.previous();
				stringListIterator.add(newCity);
				return true;
			} else if (comparsion < 0) {
				// nothing need to enter, because we already .next(), move on to the next index.
			}
		}
		// after go through the entire while loop, not able to compare the item means
		// that this newCity need to be added at the End of the list;
		{
			linkedList.add(newCity);
			return true;
		}
	}

	private static void visit(LinkedList<String> cities) {
		Scanner scanner = new Scanner(System.in);
		boolean quit = false;
		boolean goingForward = true;
		
		ListIterator<String> listIterator = cities.listIterator();
		//Java listiterator has no current object, always in next.object or previous.object
		//check the forward, backward direction
		if (cities.getFirst() == "") {
			System.out.println("No cities in the itenerary");
			return;
		} else {
			System.out.println("Now we are visiting " + listIterator.next());
			printMenu();
		}

		while (!quit) {
			int action = scanner.nextInt();
			scanner.nextLine();
			switch (action) {
			case 0:
				System.out.println("Holiday is over");
				quit = true;
				break;

			case 1: 
				if(!goingForward) {
					if(listIterator.hasNext()) {
					listIterator.next();}
					goingForward = true;
				}
				if (listIterator.hasNext()) {
					System.out.println("Now visiting " + listIterator.next());
				} else {
					System.out.println("Reached the end of the list");
					goingForward = false;
				}
				break;
			

			case 2: 
				if(goingForward) {
					if(listIterator.hasPrevious()) {
						listIterator.previous();
					}
					goingForward = false;
				}
				if (listIterator.hasPrevious()) {
					System.out.println("Now visiting " + listIterator.previous());
				} else {
					System.out.println("We are at the start of the list");
					goingForward = true;
				}
				break;
			
			case 3:
				printMenu();
				break;

			}

		}

	}

	public static void printMenu() {
		System.out.println("Available actions:\npress ");
		System.out.println(
				"0 - to quit\n" + "1 - go to next city\n" + "2 - go to previous city\n" + "3 - print menu options");
	}

}
