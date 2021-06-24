package PlayList;

import java.util.*;

public class Album {
	private String name;
	private String artist;
	private ArrayList<Song> songs;

	public Album(String name, String artist) {
		this.name = name;
		this.artist = artist;
		this.songs = new ArrayList<Song>();
	}

	public boolean addSong(String title, double duration) {
		if (findSong(title) == null) {
			Song newSong = new Song(title, duration);
			this.songs.add(newSong);
			return true;
		} else
			return false;

	}

	private Song findSong(String title) {
		for (int i = 0; i < songs.size(); i++) { // for(checkedSong: this.songs) { if
													// (checkedSong.getTitle().equals(title) )} <- make checkedSong a
													// variable for every entry of this.song add
			if (songs.get(i).getTitle().equals(title)) {
				return songs.get(i);
			}
		}
		return null;
	}

	public boolean addToPlayList(int trackNum, LinkedList<Song> playList) {
		// check if the track number is exists, and the songs is not exists then add to
		// playList, return true;
		int index = trackNum - 1;
		if ((index >= 0) && (index <= this.songs.size())) {
			playList.add(this.songs.get(index));
			return true;
		}
		System.out.println("This album doesn't have a track " + trackNum);
		return false;
	}

	public boolean addToPlayList(String title, LinkedList<Song> playList) {
		if (findSong(title) != null) {
			playList.add(findSong(title));
			return true;
		}
		System.out.println("The song " + title + " is not in this album");
		return false;
	}

}
