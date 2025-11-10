package ua.opnu;

public class BookData implements Comparable<BookData>{
    private String title;
    private String author;
    private int reviews;
    private double total;

    public BookData(String title, String author, int reviews, double total) {
        this.title = title;
        this.author = author;
        this.reviews = reviews;
        this.total = total;
    }

    private double getRating() {
        return reviews == 0 ? 0.0 : total / reviews;
    }

    @Override
    public int compareTo(BookData other) {
        double thisRating = this.getRating();
        double otherRating = other.getRating();

        if (thisRating > otherRating) {
            return -1;
        } else if (thisRating < otherRating) {
            return 1;
        } else {
            return this.title.compareTo(other.title);
        }
    }
}
