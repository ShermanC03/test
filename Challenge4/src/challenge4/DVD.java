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
public class DVD extends Media {
    private int movieYear;
    private ArrayList<String> myCoStars;
    
    public DVD(String artistName, String mediaName, int movieYear, ArrayList<String> myCoStars)
    {
        super(artistName, mediaName);
        this.movieYear = movieYear;
        this.myCoStars = new ArrayList<String>(myCoStars);
    }

    public int getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(int movieYear) {
        this.movieYear = movieYear;
    }

    public ArrayList<String> getMyCoStars() {
        return myCoStars;
    }

    public void setMyCoStars(ArrayList<String> myCoStars) {
        this.myCoStars = new ArrayList<String>(myCoStars);
    }

    @Override
    public String toString() {
        return super.toString() + "DVD{" + "movieYear=" + movieYear + ", myCoStars=" + myCoStars + '}';
    }
    
    
    
    
    
    
}
