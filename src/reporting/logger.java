package reporting;

public class logger {

    public static final String RESET = "\u001B[0m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    public static final String PINK = "\033[38;5;201m";
    public static final String RED = "\u001B[41m";
    
    public static void err(String error) {
        log(error, 1);
    }

    public static void inf(String inform) {
        log(inform, 3);
    }

    public static void log(String message, int code) {
        switch (code) {
            case 0:
                System.out.print(message + RESET + "\n");
                break;
            case 1:
                System.err.print(YELLOW + "[Warning] " + message + RESET + "\n");
                break;
            case 2:
                System.out.print(CYAN + "[Message] " + message + RESET + "\n");
                break;
            case 3:
                System.out.print(BLUE + "[System] " + message + RESET + "\n");
                break;
            case 4:
                System.out.print(PINK + "[State] " + message + RESET + "\n");
                break;
            case 5:
                System.out.print(RED + "[Error] " + message + RESET + "\n");
        }
    }
}
