package com.te.musicplayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MusicPlayerApplication {

	// creating an arraylist of MusicFiles

	static ArrayList<MusicFiles> songs = new ArrayList<MusicFiles>();
	
	//comparator for sorting the elements in order of song tiltle
	static Comparator<MusicFiles> comparator = Comparator.comparing(MusicFiles::getSongTitle);

	// method to add a song to the arraylist

	static void addSong() {
		System.out.println("please enter the details   :");
		Scanner add = new Scanner(System.in);
		System.out.println(" Enter the Song Title      :");
		String title = add.nextLine();
		title = title.toLowerCase();
		System.out.println("Enter the artist name      :");
		String artist = add.nextLine();
		System.out.println("Enter the album name       :");
		String album = add.nextLine();
		System.out.println("Enter the Song Location    :");
		String location = add.nextLine();
		System.out.println("Enter the song description :");
		String description = add.nextLine();
		int songId = 100 + (songs.size() + 1);
		boolean added = songs.add(new MusicFiles(songId, title, artist, album, location, description));
		if (added) {
			System.out.println("You have successfully Added the Song !!");
			displaySongs();
		} else {
			System.out.println("Sorry something went wrong please try again.");
		}

	}
	// end of add song method

	// method to display all songs in the arraylist
	static void displaySongs() {
		Collections.sort(songs, comparator);
		for (MusicFiles musicFiles : songs) {
			System.out.println("SONG ID          :" + musicFiles.getSongId());
			System.out.println(" SONG NAME       :" + musicFiles.getSongTitle());
			System.out.println("ARTIST           :" + musicFiles.getArtistName());
			System.out.println("ALBUM NAME       :" + musicFiles.getAlbumName());
			System.out.println("Location         :" + musicFiles.getSongLocation());
			System.out.println("Song Description :" + musicFiles.getDescription());
			System.out.println("-------------------------------------------------");
		}
	}
	// end of displaySong() method

	public static void main(String[] args) throws InterruptedException {

		// adding elements
		songs.add(new MusicFiles(101, "thum hi ho", "ARJIT SINGH", "AASHIQUI 2", "MUMBAI", "THU HI HEI MUJKO "));
		songs.add(new MusicFiles(102, "dil mein hei thum", "ARMAAN MALIK", "WHY CHEAT INDIA", "DELHI",
				"DIL MEIN HO TUM"));
		songs.add(new MusicFiles(103, "thulli thulli", "harishankar", "paiyya", "banglore", "thulli thulli mazhayai"));
		songs.add(new MusicFiles(104, "aalolam", "harishankar", "love action drama", "kannur", "thiri thiri naru"));
		songs.add(new MusicFiles(105, "kudukku", "vineeth sreenivasan", "love action drama", "chennai",
				"kudukku pottiya"));
		int homeOption = 0;
		do {
			System.out.println("    MUSIC PLAYER    ");
			System.out.println("--------------------");
			System.out.println("      --MENU--      ");
			System.out.println(" 1: -> PLAY A SONG");
			System.out.println(" 2: -> SEARCH A SONG");
			System.out.println(" 3: -> SHOW ALL SONGS");
			System.out.println(" 4: -> OPERATE ON SONGS DATABASE");
			System.out.println(" 5: -> To exit  ");
			Scanner scanner = new Scanner(System.in);
			homeOption = scanner.nextInt();

			switch (homeOption) {
			case 1: {
				System.out.println("    MUSIC PLAYER    ");
				System.out.println("--------------------");
				System.out.println("      --MENU--      ");
				System.out.println(" A: -> PLAY ALL SONGS");
				System.out.println(" B: -> PLAY SONGS RANDOMLY");
				System.out.println(" C: -> PLAY A PARTICULAR SONG");
				char option = scanner.next().charAt(0);
				if (option == 'A' || option == 'a') {
					// play songs in song title order.
					Collections.sort(songs, comparator);
					for (MusicFiles musicFiles : songs) {
						System.out.println(" ");
						System.out.println("--------NOW PLAYING--------");
						System.out.println(" SONG NAME       :" + musicFiles.getSongTitle());
						System.out.println("ARTIST           :" + musicFiles.getArtistName());
						System.out.println("ALBUM NAME       :" + musicFiles.getAlbumName());
						System.out.println("SONG LOCATION    :" + musicFiles.getSongLocation());
						System.out.println("SONG DESCRIPTION :" + musicFiles.getDescription());
						Thread.sleep(2000);

					}
					break;
				} else if (option == 'B' || option == 'b') {
					// playing songs in random order.
					Collections.shuffle(songs);
					for (MusicFiles musicFiles : songs) {
						System.out.println(" ");
						System.out.println("--------NOW PLAYING--------");
						System.out.println(" SONG NAME       :" + musicFiles.getSongTitle());
						System.out.println("ARTIST           :" + musicFiles.getArtistName());
						System.out.println("ALBUM NAME       :" + musicFiles.getAlbumName());
						System.out.println("SONG LOCATION    :" + musicFiles.getSongLocation());
						System.out.println("SONG DESCRIPTION :" + musicFiles.getDescription());
						Thread.sleep(3000);
					}
					break;
				} else if (option == 'c' || option == 'C') {
					// searching
					boolean b = false;
					System.out.println("  -> PLEASE ENTER THE SONG NAME TO SEARCH");
					scanner.nextLine();
					String search = scanner.nextLine();
					search = search.toLowerCase();
					for (MusicFiles musicFiles : songs) {
						String check = musicFiles.getSongTitle().toString();
						if (check.contains(search)) {
							// printing the elements which satisfies the condition.
							System.out.println("SONG ID          :" + musicFiles.getSongId());
							System.out.println(" SONG NAME       : " + musicFiles.getSongTitle());
							System.out.println("ARTIST           :" + musicFiles.getArtistName());
							System.out.println("ALBUM NAME       :" + musicFiles.getAlbumName());
							System.out.println("Song Location    :" + musicFiles.getSongLocation());
							System.out.println("Song Description :" + musicFiles.getDescription());
							System.out.println(" ");
							b = true;
						}
					}
					if (b) {
						// playing the song through search.
						System.out.println("Please enter the Song Id to Play : ");
						int songSearchId = scanner.nextInt();
						for (MusicFiles musicFiles : songs) {
							if (musicFiles.getSongId() == songSearchId) {
								System.out.println("-------Now Playing----------------------");
								System.out.println(" SONG NAME : " + musicFiles.getSongTitle());
								System.out.println("ARTIST :" + musicFiles.getArtistName());
								System.out.println("ALBUM NAME :" + musicFiles.getAlbumName());
								System.out.println("Location : " + musicFiles.getSongLocation());
								System.out.println("Song Description :" + musicFiles.getDescription());
								Thread.sleep(2000);

							}
						}
						break;
					} else {
						System.out.println("Song Not Found !!!!!!!");
						break;
					}
				}
				break;
			}
			case 2: {
				// search a song.
				boolean b = false;
				System.out.println("  -> PLEASE ENTER THE SONG NAME TO SEARCH");
				scanner.nextLine();
				String search = scanner.nextLine();
				for (MusicFiles musicFiles : songs) {
					String check = musicFiles.getSongTitle().toString();
					check = check.toLowerCase();
					if (check.contains(search)) {
						System.out.println("SONG ID          :" + musicFiles.getSongId());
						System.out.println(" SONG NAME       : " + musicFiles.getSongTitle());
						System.out.println("ARTIST           :" + musicFiles.getArtistName());
						System.out.println("ALBUM NAME       :" + musicFiles.getAlbumName());
						System.out.println("Song Location    :" + musicFiles.getSongLocation());
						System.out.println("Song Description :" + musicFiles.getDescription());
						System.out.println("   ");
						b = true;
					}
				}
				if (b) {
					System.out.println("Please enter the Song Id to Play : ");
					int songSearchId = scanner.nextInt();
					for (MusicFiles musicFiles : songs) {
						if (musicFiles.getSongId() == songSearchId) {
							System.out.println("-------Now Playing----------------------");
							System.out.println(" SONG NAME : " + musicFiles.getSongTitle());
							System.out.println("ARTIST :" + musicFiles.getArtistName());
							System.out.println("ALBUM NAME :" + musicFiles.getAlbumName());
							System.out.println("Location : " + musicFiles.getSongLocation());
							System.out.println("Song Description :" + musicFiles.getDescription());
							Thread.sleep(2000);

						}
					}
					break;
				} else {
					System.out.println("Song Not Found !!!!!!!");
					break;
				}
			}
			case 3: {
				// displaying all songs by displaySongs() method.
				displaySongs();
				break;
			}
			case 4: {
				System.out.println("------MUSIC PLAYER------");
				System.out.println("-----Song DataBase-----");
				System.out.println("Please enter the options from below");
				System.out.println(" A : -> Add Song");
				System.out.println(" B : -> Edit a existing Song");
				System.out.println(" C : -> Delete an existing Song");
				char optionb = scanner.next().charAt(0);
				if (optionb == 'A' || optionb == 'a') {
					// adding new elements.
					addSong();
					break;
				} else if (optionb == 'b' || optionb == 'B') {
					int editid;
					// editing the songs.
					for (MusicFiles musicFiles : songs) {
						System.out.println("Song Id : " + musicFiles.getSongId());
						System.out.println(" Song   : " + musicFiles.getSongTitle());
					}
					System.out.println("Please enter the song number to be edited");
					editid = scanner.nextInt();
					System.out.println("The Song details are : ");
					for (MusicFiles musicFiles : songs) {
						if (musicFiles.getSongId() == editid) {
							int token = 0;
							System.out.println(" SONG NAME : " + musicFiles.getSongTitle());
							System.out.println("ARTIST :" + musicFiles.getArtistName());
							System.out.println("ALBUM NAME :" + musicFiles.getAlbumName());
							System.out.println("Location : " + musicFiles.getSongLocation());
							System.out.println("Song Description :" + musicFiles.getDescription());
							while (token != 6) {
								System.out.println("What you want to edit .! please enter the options :");
								System.out.println(" 1: -> Song Title ");
								System.out.println(" 2: -> Artist Name ");
								System.out.println(" 3: -> Album Name : ");
								System.out.println(" 4: -> Song Location :");
								System.out.println(" 5: -> Song Description : ");
								System.out.println(" 6: -> Exit ");
								token = scanner.nextInt();
								switch (token) {
								case 1: {
									System.out.println(" Enter the Song Title :");
									scanner.nextLine();
									String title = scanner.nextLine();
									musicFiles.setSongTitle(title);
									System.out.println("Successfully edited ----");
									displaySongs();
									break;
								}
								case 2: {
									System.out.println("Enter the artist name :");
									scanner.nextLine();
									String artist = scanner.nextLine();
									musicFiles.setArtistName(artist);
									System.out.println("Successfully edited ----");
									displaySongs();
									break;

								}
								case 3: {
									System.out.println("Enter the album name :");
									scanner.nextLine();
									String album = scanner.nextLine();
									musicFiles.setAlbumName(album);
									System.out.println("Successfully edited ----");
									displaySongs();
									break;
								}
								case 4: {
									System.out.println("Enter Song Location : ");
									scanner.nextLine();
									String location = scanner.nextLine();
									musicFiles.setSongLocation(location);
									System.out.println("Successfully edited ----");
									displaySongs();
									break;
								}
								case 5: {
									System.out.println("Enter the song description :");
									scanner.nextLine();
									String description = scanner.nextLine();
									musicFiles.setDescription(description);
									System.out.println("Successfully edited ----");
									displaySongs();
									break;
								}
								default:
									System.out.println("Please enter the proper option :");
								}
							}
						}
					}
					break;
				} else if (optionb == 'c' || optionb == 'C') {
					// deleting a particular song
					displaySongs();
					System.out.println("Enter the song Id to delete the Song:");
					int deleteId = scanner.nextInt();
					boolean b = false;
					for (MusicFiles loop : songs) {
						if (loop.getSongId() == deleteId) {
							b = songs.remove(loop);
							System.out.println("The song has been succesfully deleted !");
							displaySongs();
							break;
						}
					}
					if (!b) {
						System.out.println("There is no such songs !!");
						break;
					}

				}
				break;

			}
			case 5: {
				// exiting.
				homeOption = 5;
				break;

			}
			default: {
				System.out.println("Please enter proper option !!");
			}

			}
		} while (homeOption != 5);
	}
}
