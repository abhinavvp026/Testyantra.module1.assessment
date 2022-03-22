package com.te.musicplayer;

public class MusicFiles {
	private int songId;
	private String songTitle;
	private String artistName;
	private String albumName;
	private String songLocation;
	private String description;

	public MusicFiles() {
		super();
	}

	public MusicFiles(int songId, String songTitle, String artistName, String albumName, String songLocation,
			String description) {
		super();
		this.songId = songId;
		this.songTitle = songTitle;
		this.artistName = artistName;
		this.albumName = albumName;
		this.songLocation = songLocation;
		this.description = description;
	}

	public int getSongId() {
		return songId;
	}

	public void setSongId(int songId) {
		this.songId = songId;
	}

	public String getSongTitle() {
		return songTitle;
	}

	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getSongLocation() {
		return songLocation;
	}

	public void setSongLocation(String songLocation) {
		this.songLocation = songLocation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "MusicFiles [songId=" + songId + ", songTitle=" + songTitle + ", artistName=" + artistName
				+ ", albumName=" + albumName + ", songLocation=" + songLocation + ", description=" + description + "]";
	}

}
