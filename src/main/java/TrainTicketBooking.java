import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class Train merepresentasikan data kereta dengan nama, stasiun keberangkatan,
 * stasiun tujuan, dan harga tiket.
 */
class Train {
    private String trainName;
    private String departureStation;
    private String destinationStation;
    private int price;

    /**
     * Konstruktor untuk membuat objek Train.
     *
     * @param trainName         Nama kereta.
     * @param departureStation  Stasiun keberangkatan kereta.
     * @param destinationStation Stasiun tujuan kereta.
     * @param price             Harga tiket kereta.
     */
    public Train(String trainName, String departureStation, String destinationStation, int price) {
        this.trainName = trainName;
        this.departureStation = departureStation;
        this.destinationStation = destinationStation;
        this.price = price;
    }

    /**
     * Mendapatkan nama kereta.
     *
     * @return Nama kereta.
     */
    public String getTrainName() {
        return trainName;
    }

    /**
     * Mendapatkan stasiun keberangkatan.
     *
     * @return Nama stasiun keberangkatan.
     */
    public String getDepartureStation() {
        return departureStation;
    }

    /**
     * Mendapatkan stasiun tujuan.
     *
     * @return Nama stasiun tujuan.
     */
    public String getDestinationStation() {
        return destinationStation;
    }

    /**
     * Mendapatkan harga tiket kereta.
     *
     * @return Harga tiket kereta.
     */
    public int getPrice() {
        return price;
    }
}

/**
 * Class Ticket merepresentasikan tiket kereta yang dipesan oleh penumpang
 * dengan informasi penumpang, kereta yang dipilih, dan nomor kursi.
 */
class Ticket {
    private Train train;
    private String passengerName;
    private int seatNumber;

    /**
     * Konstruktor untuk membuat objek Ticket.
     *
     * @param train          Objek kereta yang dipilih.
     * @param passengerName  Nama penumpang.
     * @param seatNumber     Nomor kursi penumpang.
     */
    public Ticket(Train train, String passengerName, int seatNumber) {
        this.train = train;
        this.passengerName = passengerName;
        this.seatNumber = seatNumber;
    }

    /**
     * Mencetak tiket dengan detail penumpang dan kereta.
     */
    public void printTicket() {
        System.out.println("=========== Tiket Kereta Api ===========");
        System.out.println("Nama Penumpang: " + passengerName);
        System.out.println("Nama Kereta: " + train.getTrainName());
        System.out.println("Stasiun Keberangkatan: " + train.getDepartureStation());
        System.out.println("Stasiun Tujuan: " + train.getDestinationStation());
        System.out.println("Nomor Kursi: " + seatNumber);
        System.out.println("Harga: Rp" + train.getPrice());
        System.out.println("========================================");
    }
}

/**
 * Class TrainTicketBooking adalah aplikasi utama yang mengelola pemesanan tiket
 * kereta api. Aplikasi ini menampilkan daftar kereta, meminta input dari pengguna,
 * dan mencetak tiket.
 */
public class TrainTicketBooking {
    private static ArrayList<Train> trainList = new ArrayList<>();

    /**
     * Method utama untuk menjalankan aplikasi.
     *
     * @param args Argumen baris perintah (tidak digunakan).
     */
    public static void main(String[] args) {
        initializeTrains();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selamat Datang di Sistem Pemesanan Tiket Kereta Api");
        System.out.print("Masukkan nama Anda: ");
        String passengerName = scanner.nextLine();

        displayTrainList();

        System.out.print("\nPilih nomor kereta: ");
        int trainChoice = scanner.nextInt();

        if (!isValidTrainChoice(trainChoice)) {
            System.out.println("Pilihan tidak valid.");
            return;
        }

        Train selectedTrain = trainList.get(trainChoice - 1);

        System.out.print("Masukkan nomor kursi yang diinginkan: ");
        int seatNumber = scanner.nextInt();

        Ticket ticket = new Ticket(selectedTrain, passengerName, seatNumber);
        ticket.printTicket();

        System.out.println("Terima kasih telah menggunakan sistem pemesanan tiket kereta api.");
    }

    /**
     * Menginisialisasi daftar kereta dengan menambahkan beberapa kereta beserta
     * informasi stasiun dan harga.
     */
    private static void initializeTrains() {
        trainList.add(new Train("Matarmaja", "Malang", "Jakarta", 150000));
        trainList.add(new Train("Gajayana", "Malang", "Jakarta", 450000));
        trainList.add(new Train("Argo Bromo", "Jakarta", "Surabaya", 500000));
    }

    /**
     * Menampilkan daftar kereta yang tersedia.
     */
    private static void displayTrainList() {
        System.out.println("\nDaftar Kereta:");
        for (int i = 0; i < trainList.size(); i++) {
            Train train = trainList.get(i);
            System.out.println((i + 1) + ". " + train.getTrainName() + " (" + train.getDepartureStation() + " -> " + train.getDestinationStation() + ") - Rp" + train.getPrice());
        }
    }

    /**
     * Memvalidasi pilihan kereta yang dipilih pengguna.
     *
     * @param trainChoice Pilihan kereta dari pengguna.
     * @return True jika pilihan valid, false jika tidak valid.
     */
    private static boolean isValidTrainChoice(int trainChoice) {
        return trainChoice >= 1 && trainChoice <= trainList.size();
    }
}
