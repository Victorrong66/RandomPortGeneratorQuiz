import java.util.*;

public class RandomPortQuiz {
        // Map to store port numbers and their corresponding protocols and transport types
        private static final Map<Integer, String[]> protocolMap = new HashMap<>();

        static {
            protocolMap.put(20, new String[]{"FTP", "TCP"});
            protocolMap.put(21, new String[]{"FTP", "TCP"});
            protocolMap.put(22, new String[]{"SSH/SFTP", "TCP"});
            protocolMap.put(25, new String[]{"SMTP", "TCP"});
            protocolMap.put(53, new String[]{"DNS", "UDP"});
            protocolMap.put(69, new String[]{"TFTP", "UDP"});
            protocolMap.put(80, new String[]{"HTTP", "TCP"});
            protocolMap.put(110, new String[]{"POP3", "TCP"});
            protocolMap.put(119, new String[]{"NNTP", "TCP"});
            protocolMap.put(143, new String[]{"IMAP", "TCP"});
            protocolMap.put(161, new String[]{"SNMP", "UDP"});
            protocolMap.put(162, new String[]{"SNMP", "UDP"});
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();

            while (true) {
                // Pick a random port from the map
                List<Integer> ports = new ArrayList<>(protocolMap.keySet());
                int randomPort = ports.get(random.nextInt(ports.size()));

                // Get protocol and transport type
                String[] protocolInfo = protocolMap.get(randomPort);
                String protocolName = protocolInfo[0];
                String transportType = protocolInfo[1];

                // Ask the user for input
                System.out.printf("Port %d: Enter the protocol name and transport type (TCP/UDP) separated by a space:%n", randomPort);
                String input = scanner.nextLine();

                // Check the user's input
                String[] parts = input.split(" ");
                if (parts.length == 2 && parts[0].equalsIgnoreCase(protocolName) && parts[1].equalsIgnoreCase(transportType)) {
                    System.out.println("Correct!");
                } else {
                    System.out.printf("Incorrect. The correct answer is: %s %s%n", protocolName, transportType);
                }

                // Ask if the user wants to continue
                System.out.println("Do you want to try another port? (yes/no)");
                String response = scanner.nextLine();
                if (!response.equalsIgnoreCase("yes")) {
                    break;
                }
            }

        scanner.close();
    }
}
