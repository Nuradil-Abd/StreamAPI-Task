package generate;

public class IdGenerator {
    private static Long phoneId = 0L;

    public static  long genId() {
        phoneId++;
        return phoneId;
    }
}
