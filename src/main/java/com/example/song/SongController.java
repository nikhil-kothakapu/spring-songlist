package com.example.song;


import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.song.*;
@RestController
public class SongController{
    SongService ss= new SongService();


    @GetMapping("/songs")
    public ArrayList<Song> getSongs(){
        return ss.getSongs();
    }

    @PostMapping("/songs")
    public Song addSong(@RequestBody   Song song){
        return ss.addSong(song);
    }

    @GetMapping("/songs/{songId}")
    public Song getSongById(@PathVariable("songId") int songId){
        return ss.getSongById(songId);
    }

    @PutMapping("/songs/{songId}")
    public Song updateSong(@PathVariable("songId") int songId,@RequestBody Song update ){
        return ss.updateSong(songId, update);
    }
    @DeleteMapping("/songs/{songId}")
    public void deleteSong(@PathVariable("songId") int songId){
        ss.deleteSong(songId);
    }
}

