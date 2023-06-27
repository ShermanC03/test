package challenge4;

import java.util.Comparator;

public class ComparatorByMedia implements Comparator<Media> {
    @Override
    public int compare(Media media1, Media media2) {
        return media1.getMediaName().compareToIgnoreCase(media2.getMediaName());
    }
}
