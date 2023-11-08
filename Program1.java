import java.util.Scanner;

public class Program1 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Album[] albums = new Album[3];

		for (int i = 0; i < albums.length; i++) {
			try {
				String name = scanner.nextLine();
				String artist = scanner.nextLine();
				String genre = scanner.nextLine();
				int songCount = Integer.parseInt(scanner.nextLine());
				albums[i] = new Album(name, artist, genre, songCount);
				System.out.println(albums[i]);
			} catch (Exception e) {
				System.err.println(e);
				System.err.println("Failed to read album information, redoing.");
				i--;
			}
		}

		scanner.close();

	}

}
