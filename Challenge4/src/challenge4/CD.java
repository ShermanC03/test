/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge4;

import java.util.ArrayList;

/**
 *
 * @author mtsguest
 */
public class CD extends Media {
    
    private ArrayList<String> mySongs;
    
    public CD(String artistName, String mediaName, ArrayList<String> mySongs)
    {
        super(artistName, mediaName);
        this.mySongs = new ArrayList<String>(mySongs);
        
    }

    public ArrayList<String> getMySongs() {
        return mySongs;
    }

    public void setMySongs(ArrayList<String> mySongs) {
        this.mySongs = new ArrayList<String>(mySongs);
    }

    @Override
    public String toString() {
        return super.toString() + "CD{" + "mySongs=" + mySongs + '}';
    }
    
    
    
    
    
}
