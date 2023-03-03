package com.example.song;
import java.util.*;
public interface SongRepository{
    ArrayList<Song> getSongs();
    Song addSong(Song song);

    Song getSongById(int songId);
    Song updateSong(int songId,Song update);
    void deleteSong(int songId);

}