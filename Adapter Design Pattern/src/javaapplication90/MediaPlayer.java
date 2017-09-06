/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication90;

/**
 *
 * @author NIIT
 */
public interface MediaPlayer {
    public  void Play(String audioType, String fileName);
}

interface AdvancedMediaPlayer{
    public void PlayVlc(String fileName);
    public void PlayMp4(String fileName);
}

class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void PlayVlc(String fileName) {
        System.out.println("Playing vlc file : " + fileName);
    }
    
    @Override
    public void PlayMp4(String fileName) {
        //do nothing
    }
}

class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void PlayVlc(String fileName) {
        //do nothing
    }
    
    @Override
    public void PlayMp4(String fileName) {
        System.out.println("Playing mp4 file : "+ fileName);
    }
}

class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMediaPlayer;
    
    public MediaAdapter(String audioType) {
        if(audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer = new VlcPlayer();
        } else if(audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer = new Mp4Player();
        }
    }
    
    @Override
    public void Play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer.PlayVlc(fileName);
        }else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer.PlayMp4(fileName);
        }
    }
}

class AudioPlayer implements MediaPlayer {
   MediaAdapter mediaAdapter; 

   @Override
   public void Play(String audioType, String fileName) {		

      //inbuilt support to play mp3 music files
      if(audioType.equalsIgnoreCase("mp3")){
         System.out.println("Playing mp3 file. Name: " + fileName);			
      } 
      
      //mediaAdapter is providing support to play other file formats
      else if(audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")){
         mediaAdapter = new MediaAdapter(audioType);
         mediaAdapter.Play(audioType, fileName);
      }
      
      else{
         System.out.println("Invalid media. " + audioType + " format not supported");
      }
   }   
}
