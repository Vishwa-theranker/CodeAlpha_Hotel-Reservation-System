import java.util.*;

class Room {
    int roomNumber;
    String category;
    boolean isAvailable;
    double price;
    
    Room(int roomNumber, String category, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.price = price;
        this.isAvailable = true;
    }
    
    void bookRoom() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Room " + roomNumber + " booked successfully.");
        } else {
            System.out.println("Room " + roomNumber + " is not available.");
        }
    }
    
    void freeRoom() {
        isAvailable = true;
    }
}

class Hotel {
    private List<Room> rooms;
    
    Hotel() {
        rooms = new ArrayList<>();
        rooms.add(new Room(101, "Single", 100.0));
        rooms.add(new Room(102, "Double", 150.0));
        rooms.add(new Room(103, "Suite", 250.0));
    }
    
    void showAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (room.isAvailable) {
                System.out.println("Room " + room.roomNumber + " - " + room.category + " ($" + room.price + ")");
            }
        }
    }
    
    Room getRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.roomNumber == roomNumber) {
                return room;
            }
        }
        return null;
    }
}

public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();
        
        while (true) {
            System.out.println("1. View Available Rooms\n2. Book a Room\n3. Exit");
            int choice = scanner.nextInt();
            
            if (choice == 3) break;
            
            switch (choice) {
                case 1:
                    hotel.showAvailableRooms();
                    break;
                case 2:
                    System.out.print("Enter room number to book: ");
                    int roomNumber = scanner.nextInt();
                    Room room = hotel.getRoom(roomNumber);
                    if (room != null) {
                        room.bookRoom();
                    } else {
                        System.out.println("Invalid room number.");
                    }
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}
