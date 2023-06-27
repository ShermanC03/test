/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge4;

/**
 *
 * @author mtsguest
 */
public class Media implements Comparable<Media> {
    
    private String artistName;
    private String mediaName;
    private String artist;
    
    public Media(String artistName, String mediaName)
    {
        this.artistName = artistName;
        this.mediaName = mediaName;
    }

    public String getArtistName() {
        return artistName;
    }
     public String getArtist() {
        return artist;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    @Override
    public String toString() {
        return "Media{" + "artistName=" + artistName + ", mediaName=" + mediaName + '}';
    }
    
    public int compareTo(Media aMedia)
    {
        return this.mediaName.compareTo(aMedia.mediaName);
    }
    
    
    
    
}
