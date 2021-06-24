package PlayList;

import java.util.*;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Album> albums = new ArrayList<Album>();

		Album album1 = new Album("Stormbringer", "Deep Purple");
		album1.addSong("Stormbringer", 4.6);
		album1.addSong("Love don't mean a thing", 4.22);
		album1.addSong("Holy man", 4.3);
		album1.addSong("Hold on", 5.6);
		album1.addSong("Lady double dealer", 3.21);
		album1.addSong("You can't do it right", 6.23);
		album1.addSong("High ball shooter", 4.27);
		album1.addSong("The gypsy", 4.2);
		album1.addSong("Soldier of fortune", 3.13);
		albums.add(album1);

		Album album2 = new Album("For those about to rock", "AC/DC");
		album2.addSong("For those about to rock", 5.44);
		album2.addSong("I put the finger on you", 3.25);
		album2.addSong("Lets go", 3.45);
		album2.addSong("Inject the venom", 3.33);
		album2.addSong("Snowballed", 4.51);
		album2.addSong("Evil walks", 3.45);
		album2.addSong("C.O.D.", 5.25);
		album2.addSong("Breaking the rules", 5.32);
		album2.addSong("Night of the long knives", 5.12);
		albums.add(album2);

		LinkedList<Song> playList = new LinkedList<Song>();
		albums.get(0).addToPlayList("You can't do it right", playList);
		albums.get(0).addToPlayList("Holy man", playList);
		albums.get(0).addToPlayList("Speed king", playList); // Does not exist
		albums.get(0).addToPlayList(9, playList);
		albums.get(1).addToPlayList(3, playList);
		albums.get(1).addToPlayList(2, playList);
		albums.get(1).addToPlayList(24, playList); // There is no track 24

		play(playList);

	}

	public static void play(LinkedList<Song> playList) {
		Scanner scanner = new Scanner(System.in);
		boolean quit = false;
		boolean forward = true;
		ListIterator<Song> printList = playList.listIterator();

		if (playList.size() == 0) {
			System.out.println("No songs in the playlist");
		} else {
			System.out.println("Now playing " + printList.next().toString());
			printMenu();
		}
		
		while(!quit) {
			int action = scanner.nextInt();
			scanner.nextLine();
			
			switch(action) {
			case 0:
				System.out.println("Playlist complete.");
				quit = true;
				break;
			case 1:
				//going forward
				if(!forward) {
					if (printList.hasNext()) {
						printList.next();
					}
					forward = true;
				}
				if(printList.hasNext()) {
					System.out.println("Now playing " + printList.next().toString());
				}
				else {
					System.out.println("We have reached the end of the playlist");
					forward = false;
				}
				break;
			case 2:
				//going backward
				if(forward) {
					if(printList.hasPrevious()) {
						printList.previous();
					}
					forward = false;
				}
				if(printList.hasPrevious()) {
					System.out.println("Now playing " + printList.previous().toString());
				}
				else {
					System.out.println("We have reached the start of the playlist");
					forward = true;
				}
				break;
			case 3:
				if(forward) {
					if(printList.hasPrevious()) {
						System.out.println("Now playing " + printList.previous().toString());
						forward = false; 
					}
					else {
						System.out.println("We are at the start of the list");
					}
				}
				else {
					if(printList.hasNext()) {
						System.out.println("Now playing " + printList.next().toString());
						forward = true;
					}
					else {
						System.out.println("We are at the end of the list");
					}
				}
				break;
			case 4:
				printList(playList);
				break;
			case 5: 
				printMenu();
				break;
			case 6:
				if(playList.size()>0) {
					printList.remove();
					if(printList.hasNext()) {
						System.out.println("Now playing " + printList.next().toString());
					}else if(printList.hasPrevious()) {
						System.out.println("Now playing " + printList.previous().toString());
					}
				}
				break;
			}
			
		}
		
	}
	
	private static void printMenu() {
		System.out.println("Available action:\npress");
		System.out.println("0 - to quit\n" + 
							"1 - to play next song\n" +
							"2 - to play previous song\n" +
							"3 - to replay the current song\n" +
							"4 - list songs in the playlist\n" +
							"5 - print available action");
	}
	
	private static void printList(LinkedList<Song> playList) {
		Iterator<Song> printList = playList.iterator(); //since we are not going next/previous, we dont need ListIterator, just normal Iterator.
		System.out.println("==============================");
		while(printList.hasNext()) {
			System.out.println(printList.next().toString());
		}
		System.out.println("==============================");
	}
	
	
	

}
