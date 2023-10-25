import java.util.ArrayList;
import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Movie> movieList = new ArrayList<>();

        Movie movie1 = new Movie(1, "The Shawshank Redemption", "Frank Darabont", "Drama", 122.00);
        Movie movie2 = new Movie(2, "The Godfather", "Francis Ford Coppola", "Crime, Drama", 160.00);
        Movie movie3 = new Movie(3, "Inception", "Christopher Nolan", "Action, Adventure, Sci-Fi", 148.00);
        movieList.add(movie1);
        movieList.add(movie2);
        movieList.add(movie3);

        System.out.println("Press 1 to view the list of movies, or press 0 to exit.");
        int input1 = scanner.nextInt();

        switch (input1) {
            case 1:
                for (Movie movie : movieList) {
                    movie.printMovieInfo();
                }
                printStars();
                System.out.println("Select a movie number");
                int input2 = scanner.nextInt();

                if (input2 >= 1 && input2 <= movieList.size()) {
                    Movie selectedMovie = movieList.get(input2 - 1);
                    selectedMovie.printMovieInfo();
                    bookTickets(scanner, selectedMovie);
                } else {
                    System.out.println("Invalid movie number.");
                }
                break;
            case 0:
                System.out.println("Exiting successfully");
                break;
            default:
                System.out.println("Invalid selection. The program will exit.");
        }
        scanner.close();
    }

    public static void printStars() {
        int starsCount = 36;
        for (int i = 0; i < starsCount; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public static void bookTickets(Scanner scanner, Movie movie) {
        System.out.println("Select the number of tickets to book");
        int numberOfTickets = scanner.nextInt();
        scanner.nextLine();

        if (numberOfTickets <= 0) {
            System.out.println("The number of tickets must be greater than 0.");
            return;
        }

        Ticket ticket = new Ticket(movie.getMovieNumber(), movie.getMovieName(), movie.getDirector(), movie.getGenre(), movie.getRunTime());
        ticket.setTicketDetails(numberOfTickets, scanner);
        ticket.printTicketInfo(movie);
    }
}

class Movie {
    private int movieNumber;
    private String movieName;
    private String director;
    private String genre;
    private double runTime;

    public Movie(int movieNumber, String movieName, String director, String genre, double runTime) {
        this.movieNumber = movieNumber;
        this.movieName = movieName;
        this.director = director;
        this.genre = genre;
        this.runTime = runTime;
    }

    public int getMovieNumber() {
        return movieNumber;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getDirector() {
        return director;
    }

    public String getGenre() {
        return genre;
    }

    public double getRunTime() {
        return runTime;
    }

    public void printMovieInfo() {
        MainProgram.printStars();
        System.out.println("Movie Number: " + movieNumber);
        System.out.println("Movie Title: " + movieName);
        System.out.println("Director: " + director);
        System.out.println("Genre: " + genre);
        System.out.println("Run Time: " + runTime);
    }
}

class Ticket extends Movie {
    private int numberOfTickets;
    private ArrayList<String> branches;
    private ArrayList<String> dates;
    private ArrayList<String> showTimes;
    private ArrayList<String> seatNumbers;
    private ArrayList<Integer> prices;

    public Ticket(int movieNumber, String movieName, String director, String genre, double runTime) {
        super(movieNumber, movieName, director, genre, runTime);
    }

    public void setTicketDetails(int numberOfTickets, Scanner scanner) {
        this.numberOfTickets = numberOfTickets;
        branches = new ArrayList<>();
        dates = new ArrayList<>();
        showTimes = new ArrayList<>();
        seatNumbers = new ArrayList<>();
        prices = new ArrayList();

        for (int i = 1; i <= numberOfTickets; i++) {
            System.out.println("Ticket " + i);
            System.out.println("Select a branch");
            branches.add(scanner.nextLine());
            System.out.println("Select a date");
            dates.add(scanner.nextLine());
            System.out.println("Select a showtime");
            showTimes.add(scanner.nextLine());
            System.out.println("Select a seat number");
            seatNumbers.add(scanner.nextLine());
            System.out.println("Select a price (180/200)");
            prices.add(scanner.nextInt());

            if (i < numberOfTickets) {
                scanner.nextLine();
            }
        }
    }

    public void printTicketInfo(Movie movie) {
        MainProgram.printStars();
        System.out.println("Booking Complete!! Here is your ticket");
        System.out.println("Movie Title: " + movie.getMovieName());
        System.out.println("Director: " + movie.getDirector());
        System.out.println("Genre: " + movie.getGenre());
        System.out.println("Run Time: " + movie.getRunTime());

        System.out.println("Ticket Information:");
        double totalPrice = 0.0;
        for (int i = 0; i < numberOfTickets; i++) {
            MainProgram.printStars();
            System.out.println("Ticket " + (i + 1));
            System.out.println("Branch: " + branches.get(i));
            System.out.println("Date: " + dates.get(i));
            System.out.println("Showtime: " + showTimes.get(i));
            System.out.println("Seat Number: " + seatNumbers.get(i));
            System.out.println("Price (THB): " + prices.get(i));

            totalPrice += prices.get(i);
        }
        System.out.println("Total Price (THB): " + totalPrice);
    }
}