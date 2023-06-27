package challenge4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author mtsguest
 */
public class Challenge4 {

    /**
     * @param args the command line arguments
     */
    ArrayList<Media> myMedia = new ArrayList<Media>();

    public static void main(String[] args) {
        Challenge4 challenge4 = new Challenge4();
        challenge4.run();
    }
    
    public void run() {
        try {
            loadCatalog();
            showMenu();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please make sure catalog2.txt exists.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
    }
    
    public void loadCatalog() throws FileNotFoundException {
        try {
            
    File file = new File("catalog2.txt");
        Scanner scanner = new Scanner(file);
        
        while (scanner.hasNextLine()) {
            String record = scanner.nextLine();
            createObject(record);
        }
        } catch (FileNotFoundException e) {
    e.printStackTrace();
        }
    }
    
    public void createObject(String aRecord) {
        String[] recordArr = aRecord.split(",");
        String mediaType = recordArr[0];
        String name = recordArr[1];
        String artist = recordArr[2];
        
        if (mediaType.equals("DVD")) {
            int year = Integer.parseInt(recordArr[3]);
            String coStars = recordArr[4];
            ArrayList<String> coStarsList = new ArrayList<>();
                    coStarsList.add(coStars);
                myMedia.add(new DVD(name, artist, year, coStarsList));
        } else if (mediaType.equals("CD")) {
            String songs = recordArr[3];
            ArrayList<String> songsList = new ArrayList<>();
                songsList.add(songs);
            myMedia.add(new CD(name, artist, songsList));
        }
    }
    
    public void sortByArtistPrint() {
        Collections.sort(myMedia, new ComparatorByArtist());
        
        System.out.println("Media objects sorted by artist:");
        for (Media media : myMedia) {
            System.out.println(media);
        }
        System.out.println("*******************************");
    }
    
    public void sortByMediaPrint() {
        Collections.sort(myMedia);
        
        System.out.println("Media objects sorted by name:");
        for (Media media : myMedia) {
            System.out.println(media);
        }
        System.out.println("*******************************");
    }
    
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        
        do {
            try {
                System.out.println("Menu:");
                System.out.println("1. Search by Media Name");
                System.out.println("2. Search by Artist Name");
                System.out.println("3. Add Media object");
                System.out.println("4. Quit");
                System.out.print("Enter your choice: ");
                
                choice = scanner.nextInt();
                
                switch (choice) {
                    case 1:
                        searchByMedia();
                        break;
                    case 2:
                        searchByArtist();
                        break;
                    case 3:
                        addToMedia();
                        break;
                    case 4:
                        System.out.println("Exiting program. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number from 1 to 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the input buffer
            }
        } while (choice != 4);
        
        scanner.close();
    }
    
    public void searchByMedia() {
        sortByMediaPrint();
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the Media: ");
        String mediaName = scanner.nextLine();
        
        int index = Collections.binarySearch(myMedia, new Media(mediaName, ""), Media::compareTo);
        
        if (index >= 0) {
            System.out.println(myMedia.get(index));
        } else {
            System.out.println("Media not found.");
        }
        
        System.out.println("*******************************");
    }
    
    public void searchByArtist() {
        sortByArtistPrint();
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the Artist: ");
        String artistName = scanner.nextLine();
        
        boolean found = false;
        
        for (Media media : myMedia) {
            if (media.getArtist().equals(artistName)) {
                System.out.println(media);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No matching objects found for the artist.");
        }
        
        System.out.println("*******************************");
    }
    
    public void addToMedia() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Adding a new Media object:");
        System.out.print("Enter the name of the Media: ");
        String name = scanner.nextLine();
        System.out.print("Enter the name of the Artist: ");
        String artist = scanner.nextLine();
        System.out.print("Enter the type of Media (DVD or CD): ");
        String mediaType = scanner.nextLine();
        
        if (mediaType.equals("DVD")) {
            try {
                System.out.print("Enter the year of the DVD: ");
                int year = scanner.nextInt();
                scanner.nextLine(); // Clear the input buffer
                System.out.print("Enter the co-stars of the DVD: ");
                String coStars = scanner.nextLine();
                
           ArrayList<String> coStarsList = new ArrayList<>();
            coStarsList.add(coStars);
            myMedia.add(new DVD(name, artist, year, coStarsList));

                writeToFile(new DVD(name, artist, year, coStarsList));
            } catch (InputMismatchException e) {
                System.out.println("Invalid year. Please enter a valid number.");
            }
        } else if (mediaType.equals("CD")) {
            System.out.print("Enter the songs of the CD: ");
            String songs = scanner.nextLine();
            
            ArrayList<String> songsList = new ArrayList<>();
            songsList.add(songs);
            
            myMedia.add(new CD(name, artist, songsList));
            writeToFile(new CD(name, artist, songsList));
        } else {
            System.out.println("Invalid media type. Media object not added.");
        }
        
        System.out.println("*******************************");
    }
    
    public void writeToFile(Media aMediaObj) {
        try {
            FileWriter fileWriter = new FileWriter("catalog2.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(aMediaObj.toString());
            printWriter.close();
            System.out.println("Media object added to the catalog file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
        }
    }
}
