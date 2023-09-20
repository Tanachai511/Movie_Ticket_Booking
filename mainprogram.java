import java.util.ArrayList;
import java.util.Scanner;

class MainProgram {
    public static void main(String[] args) {
    Scanner kb = new Scanner(System.in);
    ArrayList<Movie> MovieList = new ArrayList<Movie>();

    Movie Movie1 = new Movie(1, "The Shawshank Redemption", "Frank Darabont", "Drama", 122.00);
    Movie Movie2 = new Movie(2, "The Godfather", "Francis Ford Coppola", "Crime , Drama", 160.00);
    Movie Movie3 = new Movie(3, "Inception", "Christopher Nolan", "Action , Adventure , Sci-Fi", 148.00);
    MovieList.add(Movie1);
    MovieList.add(Movie2);
    MovieList.add(Movie3);

    System.out.println("Press 1 to view all movies, or press 0 to exit.");
    int input1 = kb.nextInt();
    switch (input1) {
        case 1:
            for (int i = 0; i < MovieList.size(); i++) {
                MovieList.get(i).GetMovie();
            }
            daisies();
            System.out.println("Select Movie No.");
            int input2 = kb.nextInt();
            switch (input2) {
                case 1:
                    MovieList.get(0).GetMovie();
                    break;
                case 2:
                    MovieList.get(1).GetMovie();
                    break;
                case 3:
                    MovieList.get(2).GetMovie();
                    break;
            }
            break;
        case 0:
            System.out.println("Exit successfully");
            break;
        }
        if(input1 == 1){
                System.out.println("Select the number of tickets to book");
                int numberOfTickets = kb.nextInt();
                kb.nextLine();

                Ticket ticket = new Ticket(input1, null, null, null, numberOfTickets);
                ticket.SetTicket(numberOfTickets);
                ticket.GetTicket(MovieList);
            }

        kb.close();
    }


    public static int daisies() {
        int daisies = 36;
            for (int i = 1; i <= daisies; i++) {
                System.out.print("*");
            }
        System.out.println("\n");
        return daisies;
    }
}

class Movie {
    protected int MovieNumber;
    protected String MovieName;
    protected String Director;
    protected String Genre;
    protected double RunTime;
    
    Movie(int MovieNumber,String MovieName,String Director,String Genre,double RunTime){
        this.MovieNumber = MovieNumber;
        this.MovieName = MovieName;
        this.Director = Director;
        this.Genre = Genre;
        this.RunTime = RunTime;
    }

    public void GetMovie(){ 
        daisies();
        System.out.println("No. : " + MovieNumber);
        System.out.println("Movie Title : "+this.MovieName);
        System.out.println("Director : " +this.Director);
        System.out.println("Genre : " + this.Genre);
        System.out.println("Run Time : " + this.RunTime);
    }
    
    public static int daisies() {
        int daisies = 36;
            for (int i = 1; i <= daisies; i++) {
                System.out.print("*");
            }
        System.out.print("\n");
        return daisies;
    }

}

class Ticket extends Movie {

    private int numberOfTickets;
    private ArrayList<String> branches;
    private ArrayList<String> dates;
    private ArrayList<String> showTimes;
    private ArrayList<String> seatNumbers;
    private ArrayList<Integer> prices;
    
    Ticket(int MovieNumber, String MovieName, String Director, String Genre, double RunTime) {
        super(MovieNumber, MovieName, Director, Genre, RunTime);
    }

    public ArrayList<String> getBranches() {
        return branches;
    }
    public ArrayList<String> getDates() {
        return dates;
    }
    public ArrayList<String> getShowTimes() {
        return showTimes;
    }
    public ArrayList<String> getSeatNumbers() {
        return seatNumbers;
    }
    public ArrayList<Integer> getPrice() {
        return prices;
    }


   public void SetTicket(int numberOfTickets) {
    this.numberOfTickets = numberOfTickets;
    branches = new ArrayList<>();
    dates = new ArrayList<>();
    showTimes = new ArrayList<>();
    seatNumbers = new ArrayList<>();
    prices = new ArrayList<>();

    Scanner kb = new Scanner(System.in);
    for (int i = 1; i <= numberOfTickets; i++) {
        System.out.println("Ticket " + i);
        System.out.println("Select your branch");
        branches.add(kb.nextLine());
        System.out.println("Select your Date");
        dates.add(kb.nextLine());
        System.out.println("Select your Showtime");
        showTimes.add(kb.nextLine());
        System.out.println("Select your Seat No.");
        seatNumbers.add(kb.nextLine());
        System.out.println("Select your price (180/200)");
        prices.add(kb.nextInt());

        if (i < numberOfTickets) {
            kb.nextLine();
        }
    }
}


    public void GetTicket(ArrayList<Movie> movieList) {
        daisies();
        System.out.println("Do you want to confirm your reservation?");

        Scanner kb = new Scanner(System.in);
        System.out.println("Requires confirmation. Print the movie number you booked.");
        int selectedMovieNo = kb.nextInt();

        Movie selectedMovie = null;
        for (Movie movie : movieList) {
            if (movie.MovieNumber == selectedMovieNo) {
                selectedMovie = movie;
                break;
            }
        }

        if (selectedMovie != null) {
            daisies();
            System.out.println("Booking Complete!! Here your ticket");
            System.out.println("Movie Title : " + selectedMovie.MovieName);
            System.out.println("Director : " + selectedMovie.Director);
            System.out.println("Genre : " + selectedMovie.Genre);
            System.out.println("Run Time : " + selectedMovie.RunTime);
        } else {
            System.out.println("Invalid Movie No.");
        }

        System.out.println("Ticket Information:");
        double totalPrice = 0.0;
        for (int i = 0; i < numberOfTickets; i++) {
            daisies();
            System.out.println("Ticket " + (i + 1));
            System.out.println("Branch : " + branches.get(i));
            System.out.println("Date : " + dates.get(i));
            System.out.println("Showtime : " + showTimes.get(i));
            System.out.println("Seat No. : " + seatNumbers.get(i));
            System.out.println("Price (THB) : " + prices.get(i));
            

            totalPrice += prices.get(i);
        }

        System.out.println("Total Price (THB) : " + totalPrice);
    }

    public static int daisies() {
        int daisies = 36;
        for (int i = 1; i <= daisies; i++) {
            System.out.print("*");
        }
        System.out.print("\n");
        return daisies;
    }
}
