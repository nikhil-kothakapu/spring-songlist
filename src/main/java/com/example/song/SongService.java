/*

 * You can use the following import statements
  
 

 */

package com.example.song;

import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example.song.Song;
import com.example.song.SongRepository;

// Don't modify the below code
public class SongService implements SongRepository {
    private static HashMap<Integer, Song> playlist = new HashMap<>();
    int ui=6;

    public SongService() {
        playlist.put(1, new Song(1, "Butta Bomma", "Ramajogayya Sastry", "Armaan Malik", "Thaman S"));
        playlist.put(2, new Song(2, "Kathari Poovazhagi", "Vijay", "Benny Dayal, Swetha Mohan", "A.R. Rahman"));
        playlist.put(3, new Song(3, "Tum Hi Ho", "Mithoon", "Arijit Singh", "Mithoon"));
        playlist.put(4, new Song(4, "Vizhiyil", "Vairamuthu", "Unni Menon", "A.R. Rahman"));
        playlist.put(5, new Song(5, "Nenjame", "Panchu Arunachalam", "S.P.Balasubrahmanyam", "Ilaiyaraaja"));
    }

    // Don't modify the above code

    public ArrayList<Song> getSongs(){
        Collection<Song> songCollection = playlist.values();
        ArrayList<Song> songs = new ArrayList<>(songCollection);
        return songs;
    }
    @Override
    public Song addSong(Song song){
        song.setsongId(ui);
        playlist.put(ui,song);
        ui+=1;

        return song;
    }
    @Override
    public Song getSongById(int songId){
        Song s=playlist.get(songId);
        if(s==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return s;
    }
    @Override
    public Song updateSong(int songId,Song update){
        Song exist=playlist.get(songId);

        if(exist==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if(update.getsongName()!=null){
            exist.setsongName(update.getsongName());
        }

        if(update.getlyricist()!=null){
            exist.setlyricist(update.getlyricist());
        }


        if(update.getsinger()!=null){
            exist.setsinger(update.getsinger());
        }

        if(update.getmusicDirector()!=null){
            exist.setmusicDirector(update.getmusicDirector());
        }

        return exist;


    }
    @Override
    public void deleteSong(int songId){
        Song song=playlist.get(songId);

        if(song==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            playlist.remove(songId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

}